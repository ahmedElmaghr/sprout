
---
name: java-functional-programming
description: Design and refactor Java 21 code using functional programming principles, immutable data, lambdas, streams, collectors, and safe composition. Use when improving transformations, collection processing, and function-oriented code.
---

# Java Functional Programming

## Principles
- Prefer pure functions: identical inputs should produce identical outputs without observable side effects.
- Prefer immutable values and defensive copying where appropriate.
- Separate data transformation from I/O, persistence, network calls, and other side effects.
- Use lambdas and method references when they improve readability.
- Use Stream pipelines for clear transformations, filtering, grouping, and aggregation.
- Prefer `map` for transformations, `filter` for selection, and `flatMap` for flattening nested results.
- Use collectors for aggregation rather than unnecessary mutable intermediate collections.
- Avoid deeply nested streams and excessively long pipelines. Extract named methods when intent becomes unclear.
- Do not use `peek` for business logic or essential side effects.
- Avoid parallel streams unless performance measurements justify them and the operations are safe.
- Do not introduce side effects inside stream operations when they can be expressed more clearly using a conventional loop.
- Use `Optional` to model a potentially absent return value; avoid calling `get()` without checking presence.
- Compose functions with `Function`, `Predicate`, `Consumer`, and `Supplier` when this improves reuse and clarity.
- Use `BigDecimal` for precise decimal monetary calculations.
- Avoid mutable shared state and race conditions.

## Error handling
- Do not silently discard failures inside streams.
- Keep checked-exception handling explicit when composing I/O operations.
- Avoid converting exceptional conditions into empty results unless that is the documented business behavior.

## Refactoring workflow
1. Identify inputs, outputs, side effects, and failure modes.
2. Separate pure transformations from side effects.
3. Prefer straightforward composition over clever abstractions.
4. Preserve ordering, null semantics, exception behavior, and business rules.
5. Test empty inputs, duplicates, boundary conditions, and large collections where relevant.

## Expected output
Deliver readable Java 21 code and explain why the functional approach improves clarity, correctness, or testability. Do not force streams into code that is clearer as a loop.
