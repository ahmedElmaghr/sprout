
---
name: spring-ddd-architecture
description: Design, implement, and review Spring Boot MVC applications using Domain-Driven Design, model-driven development, layered architecture, and hexagonal architecture principles.
---

# Spring Boot MVC, DDD and Model-Driven Architecture

## Architectural objectives
Keep domain concepts and business rules independent of Spring MVC, persistence technology, and external services.

## Preferred dependency direction
- Controller: HTTP endpoints, request validation, response mapping.
- Application: use-case orchestration, transaction boundaries, coordination.
- Domain: entities, value objects, aggregates, domain services, invariants.
- Ports: interfaces defining required external capabilities.
- Infrastructure: adapters implementing ports, database access, HTTP clients, messaging.

Dependencies should point inward toward the domain. The domain must not depend on Spring, JPA, HTTP frameworks, or infrastructure implementations.

## Model-driven principles
- Start from business capabilities, domain terminology, and explicit invariants.
- Model behavior and constraints in domain objects, not only as anemic data structures.
- Use ubiquitous language consistently across code, tests, and documentation.
- Define aggregate roots and consistency boundaries according to business rules.
- Represent meaningful domain concepts with value objects and explicit types.
- Distinguish domain models from persistence entities and transport DTOs when their responsibilities differ.
- Treat generated models and OpenAPI schemas as contracts or inputs, not automatically as the authoritative domain model.
- Avoid duplicating business rules across controllers, services, and persistence mappings.

## Spring MVC rules
- Controllers should translate HTTP requests into application use cases.
- Keep business decisions out of controllers and framework callbacks.
- Use request and response DTOs rather than exposing persistence entities.
- Apply consistent validation, error mapping, HTTP status codes, and API contracts.
- Do not expose internal exception details to API consumers.

## Persistence and integrations
- Define repository and external-service ports at the appropriate architectural boundary.
- Implement ports in infrastructure adapters.
- Keep Spring Data, JPA annotations, WebClient, and HTTP-specific types out of the pure domain.
- Avoid unnecessary repository calls and N+1 queries.
- Place transactions at application use-case boundaries when appropriate.
- Model external failures, timeouts, retries, and idempotency explicitly.

## Design workflow
1. Identify actors, use cases, domain concepts, and invariants.
2. Define the domain model and application ports.
3. Design application use cases.
4. Implement MVC and infrastructure adapters.
5. Verify dependency direction and business-rule ownership.
6. Test domain behavior independently from Spring.

## Expected output
Provide a package structure, responsibility breakdown, dependency direction, key interfaces, and implementation examples. Explain any deliberate architectural trade-offs. Do not introduce layers or abstractions without a clear purpose.
