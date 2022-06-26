[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=VeriDevOps_RQCODE&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=VeriDevOps_RQCODE)

# About the repository

The RQCODE repository contains security requirement idioms represented as Java code.
The purpose of this is twofold:
1. Rigorously checking whether a given system meets a given security requirement.
2. Programmatically enforcing a given requirement on a given system.

RQCODE requirements that can be checked implement the Checkable interface.
RQCODE requirements that can be enforced implement the Enforceable interface.

# Temporal patterns

Classes located under the src/main/java/rqcode/patterns/temporal directory implement some of the idiomatic temporal specification patterns (https://matthewbdwyer.github.io/psp/patterns.html), as well as their timed versions.
These classes only implement the Checkable interface.
Temporal specification patterns are generic -- for example, the ``always globally P'' pattern does not specify what P is.
Replacement of P with a meaningful property turns the pattern into a requirement.
The RQCODE classes representing the temporal patterns have constructors that expect formal arguments implementing the Checkable interface.
These arguments are objects that encode meaningful properties, such as P in the above example.
In particular, these objects may be instantiated from other RQCODE temporal patterns, for all these patterns implement the Checkable interface.

# STIGs

STIG stands for ``Security Technical Implementation Guid'' (https://www.stigviewer.com/stigs).
Each STIG is collection of security findings for a given software system (for example, for APACHE Server 2.0 for Unix https://www.stigviewer.com/stig/apache_server_2.0unix/).
Each finding includes:
- A human-friendly explanation why this finding represents a security problem.
- Technical steps required to identify the finding.
- Technical steps required to fix the finding. 

The problem with the original collection of STIGs is that the technical steps take the form of non-runnable natural language.
RQCODE classes under the src/main/java/rqcode/stigs directory implement STIG findings in an executable and reusable form.
Each RQCODE STIG finding class implements at least the Checkable interface, which makes it usable in combination with the temporal patterns.
Some finding classes also implement the Enforceable interface, which makes them usable for fixing the identified finding right after the identification.

# Examples

Main classes inside the repository contain runnable tests illustrating how the RQCODE patterns can be used in practice. 
