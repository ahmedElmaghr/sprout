
---
name: spring-mvc-rest-api
description: Design, generate, refactor, and review production-ready REST APIs using Spring Boot MVC and Java 21. Use when creating controllers, REST endpoints, request and response DTOs, validation, HTTP status codes, exception handling, pagination, or OpenAPI documentation.
---

# Spring MVC REST API Development

## Objectives

Generate REST APIs that are consistent, secure, maintainable, testable, and aligned with REST principles, Java 21 best practices, and the existing application's architecture.

## 1. Inspect Before Implementing

Before generating code:
- Inspect existing controllers, DTOs, application services, exception handlers, and API conventions.
- Check the Spring Boot and Spring Framework versions and existing dependencies.
- Review the OpenAPI specification or API contract when available.
- Reuse existing patterns instead of introducing competing conventions.
- Clarify ambiguous business requirements rather than inventing behavior.

## 2. Controller Responsibilities

- Use `@RestController` and appropriate request mappings.
- Keep controllers thin: handle HTTP concerns and delegate use cases to application services.
- Do not implement business rules, persistence logic, or complex transformations in controllers.
- Use constructor injection with `private final` dependencies.
- Avoid field injection and service locator patterns.
- Use explicit request and response types rather than exposing domain or persistence entities.
- Keep controllers focused on a single resource or cohesive API responsibility.

## 3. REST Resource Design

- Model endpoints around resources and business capabilities.
- Use nouns in URI paths and standard HTTP methods:
    - `GET` to retrieve resources.
    - `POST` to create resources or execute explicitly modeled commands.
    - `PUT` to replace a resource.
    - `PATCH` to partially update a resource.
    - `DELETE` to delete a resource.
- Use appropriate status codes, including `200`, `201`, `202`, `204`, `400`, `401`, `403`, `404`, `409`, and `422` when supported by the API contract and application semantics.
- Return `201 Created` for successful resource creation when appropriate; include a `Location` header when the created resource has a canonical URI.
- Return `204 No Content` only when no response body is intended.
- Avoid action-oriented endpoints unless they represent a legitimate business command.
- Design safe, idempotent behavior according to HTTP semantics.
- Do not change existing API contracts without explicit authorization.

## 4. Request and Response DTOs

- Define dedicated request and response DTOs when needed.
- Prefer Java 21 records for immutable DTOs where compatible with the application's serialization and validation setup.
- Use `@Valid` and Jakarta Bean Validation constraints such as `@NotNull`, `@NotBlank`, `@Size`, and `@Positive` when appropriate.
- Apply business-specific validation in the appropriate application or domain layer.
- Never rely exclusively on controller validation to enforce domain invariants.
- Avoid exposing internal identifiers, persistence fields, or sensitive information unnecessarily.
- Map between transport DTOs and application/domain models at the appropriate boundary.
- Do not introduce a mapping library solely for trivial mappings unless project conventions require it.

## 5. HTTP Semantics and Error Handling

- Use `ResponseEntity` when explicit control over status codes or headers is necessary; otherwise, prefer simpler return types.
- Use centralized exception handling with `@RestControllerAdvice` when consistent error mapping is required.
- Follow RFC 9457 Problem Details using Spring's `ProblemDetail` where supported by the configured Spring version.
- Return stable, documented error codes and meaningful messages.
- Never expose stack traces, internal class names, SQL details, credentials, or infrastructure secrets.
- Distinguish invalid requests, missing resources, conflicts, authorization failures, and unexpected server errors.
- Do not catch and suppress exceptions merely to return a successful response.
- Preserve the application's established exception-handling conventions.

## 6. Architecture and Dependency Direction

Respect the existing architectural boundaries:

- Controller: HTTP transport and request/response mapping.
- Application layer: use-case orchestration and transaction boundaries.
- Domain layer: business rules, entities, value objects, and invariants.
- Ports: interfaces for persistence and external capabilities where appropriate.
- Infrastructure: adapters, database access, and HTTP clients.

Controllers must not directly access repositories when the architecture requires application services.

Keep Spring MVC types, servlet objects, and HTTP-specific concerns outside the pure domain layer.

Do not introduce unnecessary abstractions or layers for simple use cases.

## 7. API Security

- Follow the existing Spring Security configuration and authorization model.
- Enforce authentication and authorization at the appropriate boundaries.
- Never trust client-supplied ownership, roles, prices, or other protected business attributes.
- Avoid mass assignment by accepting explicit request DTOs.
- Validate and constrain user-controlled input.
- Avoid logging secrets, tokens, or sensitive request payloads.
- Document relevant authentication and authorization requirements.
- Do not weaken security configuration to make an endpoint work.

## 8. Pagination, Filtering, and Performance

- Use the project's existing pagination conventions.
- Apply bounded page sizes and appropriate sorting rules.
- Validate filtering and sorting parameters.
- Avoid unbounded collection responses for potentially large datasets.
- Consider N+1 queries, excessive downstream calls, and unnecessary entity loading.
- Do not expose database-specific query details through public API contracts.
- Avoid blocking operations on reactive event-loop threads in applications using WebFlux.

## 9. OpenAPI and API Documentation

- Follow the existing OpenAPI configuration and annotation conventions.
- Document endpoint purpose, parameters, request bodies, responses, and relevant error cases.
- Add examples when they clarify expected usage.
- Keep documentation consistent with the actual implementation and API contract.
- Do not duplicate generated API documentation unnecessarily.
- Avoid adding annotations that merely repeat obvious information without improving the contract.

## 10. Testing Expectations

For each new or modified endpoint, consider:
- Successful request and response behavior.
- Request validation failures.
- Missing resources and business conflicts.
- Exception-to-HTTP-status mapping.
- Authentication and authorization.
- Response serialization and contract compatibility.
- Relevant application-service interactions and side effects.

Use JUnit 5 and the project's existing testing conventions.
Use `@WebMvcTest` and MockMvc for focused MVC tests where appropriate.
Use `@SpringBootTest` for broader application integration tests when necessary.
Do not mock the controller itself when testing its HTTP behavior.
Never claim tests passed unless they were actually executed.

## 11. Implementation Workflow

1. Inspect the existing API and application architecture.
2. Identify the use case, resource model, contract, and authorization requirements.
3. Define request/response DTOs and validation rules.
4. Implement the controller and delegate to the appropriate application service.
5. Apply consistent HTTP semantics and error handling.
6. Update OpenAPI documentation where necessary.
7. Add or update focused tests.
8. Run relevant checks when tooling is available.
9. Report changed files, contract changes, tests executed, and unresolved assumptions.

## Expected Output

Provide complete, compilable implementation code consistent with the repository's conventions.

Include the controller, DTOs, validation, service integration, and exception handling only where required by the use case.

Explain non-obvious HTTP design decisions and identify any API compatibility or security risks.

Prefer the smallest complete implementation over speculative abstractions.
