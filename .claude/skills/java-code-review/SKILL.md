---
name: java-code-review
description: Review Java and Spring Boot code for bugs, maintainability, security, performance, and testing quality. Use when reviewing a pull request or evaluating a code change.
allowed-tools: read_file grep
compatibility: Requires file system access and git repository context.
---

# Java Code Review

Review Java code using these principles:

1. Identify correctness issues and potential runtime failures.
2. Check Spring dependency injection and transaction boundaries.
3. Evaluate exception handling, validation, and logging.
4. Check security risks and sensitive data exposure.
5. Identify performance issues, especially unnecessary database or HTTP calls.
6. Evaluate unit tests and missing edge cases.

For each finding, provide:
- Severity: Critical, High, Medium, or Low.
- The affected code or behavior.
- Why it is a problem.
- A concrete recommendation.

Do not report stylistic preferences as bugs.
