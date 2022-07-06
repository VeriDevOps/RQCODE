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
