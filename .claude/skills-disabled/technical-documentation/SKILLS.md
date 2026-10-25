
---
name: technical-documentation
description: Create and maintain accurate technical documentation for Java 21 and Spring Boot systems, including architecture, APIs, configuration, deployment, troubleshooting, and developer onboarding.
---

# Technical Documentation

## Objectives
Produce accurate, concise, maintainable documentation that helps developers understand, operate, test, and evolve the system.

## Documentation principles
- Base documentation on the actual codebase, configuration, tests, and verified behavior.
- Never invent endpoints, properties, environment variables, dependencies, architecture decisions, or deployment steps.
- Distinguish verified facts from assumptions and unresolved questions.
- Prefer actionable instructions and concrete examples over vague descriptions.
- Use consistent terminology and follow the domain's ubiquitous language.
- Keep documentation aligned with the implemented behavior.

## Required documentation types
Choose the relevant sections for the requested task:

### Project overview
- Business purpose and major capabilities.
- Technology stack and supported Java/Spring Boot versions.
- High-level architecture and important dependencies.

### Developer onboarding
- Prerequisites and local setup.
- Build, test, run, and debugging commands.
- Required configuration and safe secret management.
- Common setup failures and troubleshooting.

### Architecture
- Component responsibilities and dependency direction.
- Domain model, application use cases, ports, and adapters.
- Important design decisions, constraints, and trade-offs.
- Mermaid diagrams when they clarify component interactions or workflows.

### API documentation
- HTTP methods, paths, request/response examples, validation, and error behavior.
- Authentication and authorization requirements.
- OpenAPI contracts where applicable.

### Configuration and operations
- Property names, purpose, defaults, and environment-specific overrides.
- External dependencies, health checks, logs, metrics, and operational risks.
- Deployment, rollback, and troubleshooting procedures when verified.

## Maintenance workflow
1. Inspect source code, tests, configuration, and existing documentation.
2. Identify the target audience and intended use.
3. Generate only relevant sections.
4. Verify every command, property, endpoint, and code example against the repository.
5. Update existing documentation instead of creating duplicate sources of truth.
6. Identify missing information rather than guessing.

## Output standards
- Use Markdown with clear headings, concise tables, and executable examples.
- Use Mermaid only when it adds explanatory value.
- Include prerequisites and expected outcomes for procedures.
- Never include real credentials, tokens, private customer data, or sensitive infrastructure details.
- Keep documentation consistent with the actual implementation.

## Completion criteria
List the files created or updated, the sources inspected, and any assumptions or verification gaps. Do not claim generated commands or examples were executed unless they were actually tested.
