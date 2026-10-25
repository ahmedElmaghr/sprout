
---
name: java-unit-testing-tdd
description: Develop Java 21 unit tests using Test-Driven Development, JUnit 5, Mockito, and clear behavioral assertions. Use when implementing new features, fixing bugs, or refactoring business logic.
---

# Java Unit Testing with TDD

## Mandatory TDD cycle
Follow Red -> Green -> Refactor:
1. RED: Write a focused test that expresses one expected behavior and fails for the intended reason.
2. GREEN: Implement the smallest change that makes the test pass.
3. REFACTOR: Improve the design while keeping all tests passing.

Do not implement the entire feature first and add tests afterward when working in explicit TDD mode.

## Testing principles
- Test observable behavior, not implementation details.
- Use JUnit 5 and Mockito where appropriate.
- Follow Arrange-Act-Assert.
- Name tests using meaningful behavior-oriented names.
- Cover success, failure, boundary, and relevant null/empty cases.
- Verify business invariants and regression scenarios.
- Prefer real domain objects and value objects over excessive mocks.
- Mock external boundaries such as repositories, remote clients, and gateways when isolation is required.
- Avoid mocking simple data carriers or methods of the class under test.
- Avoid unnecessary stubbing and interaction verification.
- Use parameterized tests for meaningful sets of inputs.
- Keep tests deterministic, independent, and fast.
- Never depend on live networks, real credentials, execution order, or shared mutable state.

## Assertions
- Assert outcomes and meaningful state changes.
- Verify exceptions and their relevant attributes.
- Use precise assertions rather than checking only that an object is non-null.
- Avoid asserting private implementation details or incidental call counts.

## Test structure
- Unit-test domain rules without Spring context.
- Unit-test application services with mocks only at their boundaries.
- Keep test fixtures readable; introduce builders only when they reduce complexity.
- Follow existing project conventions and naming patterns.

## Bug fixes
1. Reproduce the defect with a failing regression test.
2. Confirm the test fails because of the defect.
3. Apply the smallest correct fix.
4. Confirm the regression test passes.
5. Run related tests to detect regressions.

## Completion criteria
- Report the tests created and the behaviors covered.
- Execute tests when tooling is available.
- Never weaken assertions, delete useful tests, or change expected behavior merely to obtain a green build.
- If tests cannot be run, state that explicitly.
