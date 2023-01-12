# RQCODE Example
In this package we provide source code for the RQCODE example. The Clock class has secods filed that is incremented when the Clock ticks.

Two requirements apply:
* (REQ1) A clock tick increments current second if it is smaller than 59.
Adapted from https://www.sciencedirect.com/science/article/abs/pii/S1477842416301981

* (REQ2) Clock seconds must be between 0 and 59.

## REQ 1 is implemented in the TickRequirement class.
https://github.com/VeriDevOps/RQCODE/blob/6b68ed67c4091e22a3aa89336eba9eb95fe5e512/src/main/java/rqcode/example/TickRequirement.java#L12

* statement is intitialized in the constructure with the textual representation of the requirement
* check() impelemnts the verification that ensures the REQ1 satisfiability

The REQ2 is implemented in the BoundaryRequirement class.
https://github.com/VeriDevOps/RQCODE/blob/6573091284af8ff9dc12248b642d8c6c902a3014/src/main/java/rqcode/example/BoundaryRequirement.java#L12

The Main class gives an example of the verification execution:
https://github.com/VeriDevOps/RQCODE/blob/6573091284af8ff9dc12248b642d8c6c902a3014/src/main/java/rqcode/example/Main.java#L8