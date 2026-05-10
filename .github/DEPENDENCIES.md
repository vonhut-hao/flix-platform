# Dependency Summary

This document summarizes runtime and test dependencies by module, based on current `pom.xml` and `package.json` files.

## Backend (Maven)

### `be/pom.xml` (parent)
Direct dependencies:
- `org.projectlombok:lombok` (provided)
- `org.springframework.boot:spring-boot-starter-test`
- `org.springframework.boot:spring-boot-devtools`
- `tools.jackson.core:jackson-databind`

Dependency management (BOM/import):
- `org.springframework.boot:spring-boot-dependencies:${spring-boot.version}` (import)
- `org.testcontainers:testcontainers-bom:${mysql.testcontainers.version}` (import)
- `io.awspring.cloud:spring-cloud-aws-dependencies:${io.awspring.cloud.version}` (import)

Managed artifacts (versioned in parent):
- `org.mapstruct:mapstruct`
- `com.mysql:mysql-connector-j`
- `org.apache.groovy:groovy` (test)
- `org.spockframework:spock-core` (test)
- `org.spockframework:spock-spring` (test)
- `io.rest-assured:rest-assured` (test)

### `be/app/pom.xml`
- `org.springframework.boot:spring-boot-starter-web`
- `com.mysql:mysql-connector-j`
- `org.springframework.boot:spring-boot-jpa`
- `com.flix:identity:${project.version}`
- `org.springframework.boot:spring-boot-starter-actuator`
- `org.springframework.boot:spring-boot-starter-flyway`
- `org.flywaydb:flyway-mysql`

### `be/common/pom.xml`
- `org.springframework.boot:spring-boot-starter-data-jpa`
- `org.springframework.boot:spring-boot-starter-validation`
- `com.fasterxml.jackson.core:jackson-annotations`
- `org.springframework:spring-web`
- `com.mysql:mysql-connector-j` (runtime)

### `be/identity/pom.xml`
- `org.springframework.boot:spring-boot-security-oauth2-resource-server`
- `org.springframework.boot:spring-boot-security`
- `org.springframework.boot:spring-boot-starter-data-jpa`
- `org.springframework.boot:spring-boot-starter-validation`
- `io.awspring.cloud:spring-cloud-aws-starter-parameter-store`
- `org.mapstruct:mapstruct`
- `com.flix:common:${project.version}` (compile)
- `com.flix:common:${project.version}` (test-jar, test)
- `org.springframework.boot:spring-boot-starter-security-oauth2-client`
- `org.apache.tomcat.embed:tomcat-embed-core`

### `be/flix-integration-test/pom.xml`
- `io.rest-assured:rest-assured` (test)
- `org.testcontainers:mysql` (test)
- `org.springframework.boot:spring-boot-testcontainers` (test)
- `org.testcontainers:junit-jupiter` (test)
- `com.flix:app:1.0-SNAPSHOT` (test)
- `com.flix:identity:1.0-SNAPSHOT` (test)
- `org.apache.groovy:groovy:${groovy.version}` (test)
- `org.spockframework:spock-core` (test)
- `org.spockframework:spock-spring` (test)

## Frontend (npm)

### `fe/package.json`
Dependencies:
- `vue`

Dev dependencies:
- `@types/node`
- `@vitejs/plugin-vue`
- `@vue/tsconfig`
- `typescript`
- `vite`
- `vue-tsc`

