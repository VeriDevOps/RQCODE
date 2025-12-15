# RQCODE Clock Example

This package demonstrates the RQCODE approach using a simple Clock example adapted from the [Seamless Requirements paper](https://www.sciencedirect.com/science/article/abs/pii/S1477842416301981).

## The Clock System

The `Clock` class has a `seconds` field that is incremented when the clock ticks.

## Requirements

Two requirements apply to the Clock system:

### REQ1: Tick Increment Requirement
*"A clock tick increments current second if it is smaller than 59."*

Implemented in `TickIncrementRequirement.java`:
- The `statement` is initialized in the constructor with the textual representation of the requirement
- The `check()` method implements the verification that ensures REQ1 satisfiability

### REQ2: Boundary Requirement
*"Clock seconds must be between 0 and 59."*

Implemented in `TickBoundaryRequirement.java`.

## Reuse Mechanisms

The example also demonstrates RQCODE's reuse mechanisms:

### Inheritance
`DerivedTickBoundaryRequirement` extends `TickIncrementRequirement` to combine both requirements through inheritance.

### Composition
`CombinedTickRequirement` combines multiple requirements through composition.

### Temporal Patterns
`TimedTickRequirement` wraps requirements with temporal monitoring using the `GlobalUniversalityTimed` pattern.

## Running the Example

```bash
# Run the basic example
java -cp target/RQCODE-1.0.2-SNAPSHOT.jar rqcode.example.Main

# Run the temporal patterns example
java -cp target/RQCODE-1.0.2-SNAPSHOT.jar rqcode.example.MainTemporal
```

## Classes

| Class | Description |
|-------|-------------|
| `Clock` | The system under test with a `seconds` field and `tick()` method |
| `TickIncrementRequirement` | Verifies that ticking increments seconds correctly |
| `TickBoundaryRequirement` | Verifies that seconds stay within 0-59 bounds |
| `DerivedTickBoundaryRequirement` | Demonstrates inheritance-based reuse |
| `CombinedTickRequirement` | Demonstrates composition-based reuse |
| `TimedTickRequirement` | Demonstrates temporal pattern integration |
| `Main` | Basic verification example |
| `MainTemporal` | Temporal monitoring example |
