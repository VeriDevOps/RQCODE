# Temporal and real-time security requirement patterns

Requirements often take forms more complicated than simple checks of a system snapshot.
In the extreme case they take the form of temporal properties with real time deadlines.
Sometimes these properties look so tricky in timed temporal logics that only an expert can deal with them.
Also, such properties too often fall into a limited set of specification patterns.

## Global universality pattern and its timed version

The global universality pattern takes the following form: *"Globally, it is always the case that P holds."*
Its timed version sets the minimal time period during which the desired property should be observed: *"Globally, it is always the case that P holds for at least T time units."*
This and other universality patterns are available in different notations [online](https://people.cs.ksu.edu/~dwyer/SPAT/universality.html).

## Global real time response pattern (timed)

The global real time response pattern takes the following form: *"Globally, it is always the case that if P holds, the S eventually holds within T time units."*
This and other response patterns are available [online](https://matthewbdwyer.github.io/psp/patterns/response.html).

## After-until universality pattern and its timed version

The after-until universality pattern takes the following form: *"After Q, it is always the case case that P holds until R holds."*
Its timed version depends on two deadlines: *"After Q holds for T time units, it is always the case that P holds until R holds for at most T1 time units."*

# RQCODE implementation of security requirement patterns

When applying the RQCODE approach to the [Temporal and real-time security requirement patterns](#temporal-and-real-time-security-requirement-patterns), we wanted to take advantage of the already implemented STIG rules.
In particular, we wanted the checks inside the STIGs implementations to be reusable as the properties the temporal patterns talk about.

## Checkable interface

All RQCODE implementations of the STIG rules implement `Checkable` interface that offers a method returning the result of checking the target system against the corresponding rule:
```java
public interface Checkable {
    enum CheckStatus {
        PASS, FAIL, INCOMPLETE
    }

    CheckStatus check();
}
```

## Abstract monitoring loop
To check a temporal real time property means to monitor the target system over some period to see if it meets the desired property. This is why all RQCODE implementations of these patterns are descendants of `MonitoringLoop` class that implements the `Checkable` interface:
```java
public abstract class MonitoringLoop implements Checkable {
    protected int boundary = 0;
    final private int variant(int i) {
        if (boundary > 0) { return i - 1; }
        return i;
    }
    protected int sleepMilliseconds() { return 1000; }
    protected boolean invariant() { return true; }
    protected boolean precondition() { return true; }
    protected boolean postcondition() { return true; }
    protected boolean exitCondition() { return false; }
    final public Checkable.CheckStatus check() {
        while(!precondition()) {
            try {
                Thread.sleep (sleepMilliseconds());
            } catch (InterruptedException e) {
                return Checkable.CheckStatus.INCOMPLETE;
            }
        }
        for (int i = boundary; i >= 0 && !exitCondition(); i = variant(i)) {
            if (!invariant()) {
                return Checkable.CheckStatus.FAIL;
            }
            try {
                Thread.sleep (sleepMilliseconds());
            } catch (InterruptedException e) {
                return Checkable.CheckStatus.INCOMPLETE;
            }
        }
        if(!postcondition()) {
            return Checkable.CheckStatus.FAIL;
        }
        return Checkable.CheckStatus.PASS;
    }

    abstract public String TCTL();

}
```
The `check()` method contains the monitoring loop itself. Its implementation cannot be redefined but is expressed in terms of conceptual methods that can be redefined in descendant classes:
- `boundary` limits the number of time units to execute the loop; `0` means no bound;
- `sleepMilliseconds()` controls the length of a time unit in milliseconds;
- `invariant()` must hold on every step of the loop;
- the loop waits for `precondition()` to hold before it start checking desired properties;
- `postcondition()` is checked after the loop terminates;
- `exitCondition()` specifies the exit condition of the loop.
Security requirements may not only be monitored but also model checked. The `TCTL()` abstract method of the `MonitoringLoop` class forces concrete classes to implement TCTL representation of the pattern. The `variant(int i)` method implements bounded (un)execution of the monitoring loop: if the value of boundary is 0 then variant returns the value of its argument unchanged; otherwise, it returns the decremented value of the argument. If the input value does not change, the `i >= 0` part of the continuation condition of the loop will remain true forever, and the loop will only exit if `exitCondition()` becomes true.

## Example: Global Universality pattern

The following class implements the Global Universality pattern: 
```java
public class GlobalUniversality extends MonitoringLoop {
```
The class contains a `Checkable` field `p` that captures the condition expected to hold forever:
```java
public GlobalUniversality(Checkable p) {
    this.p = p;
}
protected Checkable p;
```
The class overrides the `invariant()` method so that it only returns true if `p` passes the check:
```java
@Override
public boolean invariant() {
    return (p.check() == CheckStatus.PASS);
}
```
This `check()` method of `MonitoringLoop` will repeatedly check this condition inside the loop.

This is how the TCTL representation of the pattern is constructed:
```java
public String TCTL() {
    String pStr;
    if (p instanceof MonitoringLoop) {
        pStr = ((MonitoringLoop) p).TCTL();
    } else {
        pStr = p.getClass().getSimpleName();
    }
    return "AG (" + pStr + ")";
}
```
If `p` itself implements `MonitoringLoop`, we embed its TCTL representation into the generic TCTL scheme of the pattern; otherwise, we embed the name of the dynamic type of `p`. 

We do not discuss how the textual representation is computed inside the `toString()` method because its implementation is straightforward.

## Timed versions of existing patterns

The timed version of the global universality pattern extends the non-timed version:
```java
public class GlobalUniversalityTimed extends GlobalUniversality {
```
We update the constructor so that it can also bound the execution of the monitoring loop:
```java
public GlobalUniversalityTimed(Checkable p, int boundary) {
    super(p);
    this.boundary = boundary;
}
```
The `TCTL()` and `toString()` methods are updated accordingly in a straightforward way.


# Example of a temporal RQCODE requirement

In the context of the VeriDevOps project we were given a case study to verify the application of STIG rules for Industrial PC running Windows 10 operating system.
In this section we will see an example of applying the RQCODE patterns.
The example combines the temporal patterns with STIG patterns to monitor it continuously.

The following line creates an object from the RQCODE class implementing the [V_63449 STIG rule](https://www.stigviewer.com/stig/windows_10/2016-06-08/finding/V-63449):
```java
V_63449 v_63449 = new V_63449();
```
We then can construct a timed global universality RQCODE requirement from `v_63349` since this rule should be permanently enforced:
```java
GlobalUniversalityTimed globalUniversality_V_63449 = new GlobalUniversalityTimed(v_63449, Integer.MAX_VALUE);
```
Property `V_63449` is expected to globally hold for at least `Integer.MAX_VALUE` time units.

Let us now create another object from another STIG rule’s RQCODE implementation:
```java
V_63467 v_63467 = new V_63467();
```
Now we have `v_63449` and `v_63467` at our disposal and can construct an RQCODE requirement from the timed global response pattern:
```java
GlobalResponseTimed globalResponseTimed_V_63449_V_63447 = new GlobalResponseTimed(v_63449, v_63467, Integer.MAX_VALUE);
```
The resulting requirement expresses the following: *"globally, whenever v_63449 holds, v_63467 should hold within Integer.MAX_VALUE time units"*.

But it is not only possible to construct pattern-based RQCODE requirements from "primitive" implementers of the `Checkable` interface – the "building blocks" may by other pattern-based requirements:
```java
GlobalResponseTimed globalResponseTimedComposite =
    	new GlobalResponseTimed(globalUniversality_V_63449,
           	globalResponseTimed_V_63449_V_63447, Integer.MAX_VALUE);
```
We can print out textual representations of the constructed objects:
```java
System.out.println(globalResponseTimedComposite);
```
We can also print out a TCTL representation:
```java
System.out.println(globalResponseTimedComposite.TCTL());
```
The previous line will produce the following output:
```
AG((AG >=2147483647 (V_63449)) ==> (AF <= 2147483647 (AG((V_63449) ==> (AF <= 2147483647 (V_63467))))))
```
Finally, it is possible to monitor RQCODE requirements by calling `check()`:
```java
System.out.println(globalResponseTimedComposite.check());
```
It will launch the monitoring loop and check whether the property captured by the object holds.
