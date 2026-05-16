# Copilot Instructions

## Project map
- Monorepo layout:
  - `be/`: Java backend (Maven multi-module).
  - `fe/`: Vue 3 + Vite + TypeScript frontend.
  - `infra/`: infrastructure assets.
  - `docker-compose.yml`: local MySQL service.
- Backend root is `be/pom.xml` with modules:
  - `common`
  - `app`
  - `identity`
  - `flix-integration-test`

## Backend architecture
- Boot entry point: `be/app/src/main/java/com/flix/app/FlixPlaftformApplication.java`.
- `common` module contains shared DTOs and common configuration/utilities.
- `identity` module contains authentication/authorization logic with package split:
  - `api`: REST controllers (e.g., auth/user endpoints)
  - `auth`: auth/security config, DTOs, services, handlers
  - `dao`: persistence entities and repositories
- `app` module wires runtime application concerns and imports identity/common configuration.
- Integration tests live in `be/flix-integration-test` (Spock + Testcontainers + Rest Assured).

## Configuration and data
- Main app config: `be/app/src/main/resources/application.yml`.
- Imported module configs:
  - `be/common/src/main/resources/common.yml`
  - `be/identity/src/main/resources/identity.yml`
- Local profile config: `be/app/src/main/resources/application-local.yml`.
- Flyway migrations: `be/app/src/main/resources/db/migration`.
- Local DB: MySQL from `docker-compose.yml` (`flix-db`).

## Frontend quick notes
- Entry: `fe/src/main.ts`
- Root component: `fe/src/App.vue`
- Scripts: `dev`, `build`, `preview` in `fe/package.json`.

## Build and test
- Backend baseline (from `be/pom.xml`):
  - Java 25
  - Spring Boot 4.0.6
  - Lombok + MapStruct annotation processors
- Run backend commands from `be/`.
- Run frontend commands from `fe/`.

## PR workflow helper
- PR authoring and update guidance is in:
  - `.github/copilot/skills/CREATE_OR_UPDATE_PR.md`

## Issue workflow helper
- Issue authoring and update guidance is in:
  - `.github/skills/CREATE_OR_UPDATE_ISSUE.md`

