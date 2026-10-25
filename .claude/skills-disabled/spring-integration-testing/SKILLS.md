
---
name: spring-integration-testing
description: Write Spring Boot integration tests that validate application wiring, dependency injection, HTTP endpoints, persistence, transactions, serialization, and external integration boundaries using JUnit 5 and Spring Test.
---

# Spring Boot Integration Testing

## Objectives
Verify that real application components collaborate correctly in a Spring application context.

## Test strategy
- Use `@SpringBootTest` when testing the full application context is necessary.
- Use `@WebMvcTest` for focused Spring MVC slice tests.
- Use `@DataJpaTest` for JPA repository and persistence behavior.
- Use `@AutoConfigureMockMvc` with MockMvc for serverless MVC integration tests.
- Use `WebTestClient` when appropriate for WebFlux or supported HTTP testing.
- Avoid loading the full application context when a narrower test provides sufficient confidence.

## Testing principles
- Validate actual dependency injection, configuration, serialization, validation, and exception handling.
- Use a real database or a suitable disposable test database when database behavior matters.
- Use Testcontainers when integration fidelity with the production database or infrastructure is important.
- Mock external HTTP services at the network boundary rather than mocking the application component being tested.
- Use WireMock or an equivalent HTTP stub when testing request construction, response mapping, and remote failure handling.
- Test authentication and authorization where applicable.
- Verify transaction behavior, persistence state, and rollback semantics where relevant.
- Cover HTTP status codes, response contracts, validation errors, and relevant headers.
- Test timeouts, unavailable dependencies, and malformed responses for critical integrations.
- Keep tests isolated and deterministic; clean up external state where necessary.

## Spring context management
- Reuse compatible application contexts to keep test execution efficient.
- Avoid excessive `@DirtiesContext` usage.
- Configure test-specific properties using supported Spring test configuration mechanisms.
- Do not require production secrets or connect to production services.
- Never disable important security or validation behavior simply to make tests pass.

## Execution workflow
1. Identify the application boundary and integration behavior.
2. Select the narrowest appropriate Spring test context.
3. Configure real components and controlled external dependencies.
4. Exercise the behavior through its public boundary.
5. Assert both the observable response and relevant side effects.
6. Run the test and investigate failures instead of hiding them.

## Completion criteria
Report the context loaded, components integrated, external dependencies simulated, and behaviors verified. Clearly distinguish tests that were executed from tests that were only generated.
