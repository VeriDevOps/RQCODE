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

For a detailed example, please read the corresponding [documentation](https://github.com/VeriDevOps/RQCODE/blob/master/src/main/java/rqcode/patterns/temporal#readme).

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

# Example: Windows 10 STIG Rules as RQCODE style requirements

To demonstrate the approach we will illustrate it with an example of specific STIG rules for systems run by the Windows 10 operating system.
These rules are provided in the Windows 10 Security Technical Implementation Guide.
For many systems, STIG rules come scripts for verifying the conformance and enforcing the rules.
For Windows 10, PowerShell scripts exist that check conformance of systems to these rules.
For some rules, such checks are complemented with scripts that enforce conformance to the respective rules.

We had analyzed the STIG rules for Windows 10 and found subgroups of rules that look very similar - both in their textual descriptions and in the PowerShell scripts (where applicable) that check and enforce conformance to these rules.
This is bad, because a decision to modify one rule from such a subgroup would require synchronizing the change with all the similar rules, and this process is prone to errors.
We decided to apply the object-oriented software construction process to remove the repetition. The below class tree depicts a subset of the resulting collection of classes:
![image10](https://user-images.githubusercontent.com/6912490/177565254-151cd3f3-a8bb-415a-833e-bb61a0264177.png)
The leaves of the tree correspond to actual STIG rules. The abstract classes encode the commonalities shared by their descendant classes. Each class implementing a STIG rule features up to three public methods:
- toString(), which prints out the textual representation of the STIG rule;
- check(), which performs conformance-checking of the target system against the rule;
- enforce(), which enforces conformance of the target system against the rule.

For more details, please read the corresponding [documentation](https://github.com/VeriDevOps/RQCODE/tree/master/src/main/java/rqcode/stigs/win10#readme).
