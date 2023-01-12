# RQCODE Example
In this package we provide source code for the RQCODE example. The Clock class has secods filed that is incremented when the Clock ticks.

Two requirements apply:
* (REQ1) A clock tick increments current second if it is smaller than 59.
Adapted from https://www.sciencedirect.com/science/article/abs/pii/S1477842416301981

* (REQ2) Clock seconds must be between 0 and 59.

## REQ 1 is implemented in the TickRequirement class.
https://github.com/VeriDevOps/RQCODE/blob/6b68ed67c4091e22a3aa89336eba9eb95fe5e512/src/main/java/rqcode/example/TickRequirement.java#L12

