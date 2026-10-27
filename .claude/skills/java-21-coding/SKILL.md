---
name: java-21-coding
description: Write, refactor, and review production-quality Java 21 code using modern language features, clean code principles, SOLID, and secure coding practices. Use for Java implementation, bug fixes, and code reviews.
allowed-tools: read_file grep
compatibility: Requires file system access and git repository context.
---

# Java 21 Coding Standards

## Objectives
Produce readable, maintainable, testable, secure, production-ready Java 21 code.

## Rules
- Target Java 21. Use modern features when they improve clarity, not merely because they exist.
- Prefer `record` for immutable data carriers and DTOs where appropriate.
- Use sealed classes and interfaces when a closed type hierarchy improves domain modeling.
- Use switch expressions and pattern matching where they simplify logic.
- Use `var` only when the inferred type is obvious. Prefer explicit types in public APIs and complex declarations.
- Prefer constructor injection and `private final` dependencies in Spring components.
- Apply SOLID, separation of concerns, encapsulation, and composition over inheritance.
- Keep methods focused, small, and named according to their intent.
- Validate inputs at application boundaries. Enforce domain invariants inside domain objects.
- Use `Optional` primarily for return values representing possible absence, not for entity fields or method parameters.
- Avoid returning `null`; use explicit absence or empty collections as appropriate.
- Use specific exceptions. Never swallow exceptions or catch `Exception` without a justified boundary-level reason.
- Never log credentials, access tokens, personal data, or secrets.
- Avoid unnecessary abstractions, mutable shared state, premature optimization, and speculative generalization.
- Preserve backward compatibility unless a breaking change is explicitly requested.

## Spring Boot conventions
- Keep controllers thin and free of business logic.
- Separate application orchestration, domain rules, and infrastructure concerns.
- Use configuration properties for externalized configuration.
- Apply transactions at appropriate application/service boundaries.
- Avoid blocking calls on reactive event-loop threads.

## Workflow
1. Inspect existing conventions and surrounding code.
2. Understand the requirement and edge cases.
3. Implement the smallest complete solution.
4. Check error handling, security, concurrency, and performance.
5. Run relevant tests and report any unverified assumptions.

## Expected output
Provide implementation-ready code, explain non-obvious decisions, identify risks, and list tests executed. Never claim tests passed unless they were actually run.
