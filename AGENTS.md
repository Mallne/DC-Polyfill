# Dicentra Polyfill

A Kotlin Multiplatform (KMP) utility library providing contracts, extensions, and validation helpers for the DiCentra Application Framework.

## Project Overview

**Dicentra Polyfill** is designed to provide missing or enhanced utility functions that facilitate cleaner and more expressive Kotlin code. It leverages Kotlin Contracts to provide static analysis hints for common checks and offers specialized validation logic for both primitive and reflected properties.

### Key Technologies
- **Kotlin Multiplatform (KMP):** Supports JVM, Android, JS, Wasm, iOS, and Linux targets.
- **Kotlin Contracts:** Used in `ensure` and `probe` functions to inform the compiler about nullability and boolean conditions.
- **Gradle Kotlin DSL:** For project configuration and build management.
- **Maven Publish Plugin:** Configured for publishing to a private Nexus/Maven registry.
- **Kotlin Reflection:** Utilized in JVM-specific source sets for property-based validation.

### Architecture
The project follows the standard KMP structure:
- `commonMain`: Contains core utilities (`contracts.kt`, `extensions.kt`, `Validation.kt`, `InternalProxyObject.kt`).
- `jvmMain`: Extends `Validation` with reflection-based helpers for JVM-specific environments.
- `androidLibrary`: Configured as an Android library target.

## Building and Running

### Prerequisites
- JDK 21 (configured as the toolchain).
- Gradle (use the provided wrapper).

### Common Commands
- **Build all targets:**
  ```bash
  ./gradlew build
  ```
- **Run tests:**
  ```bash
  ./gradlew test
  ```
- **Run JVM-specific tests:**
  ```bash
  ./gradlew jvmTest
  ```
- **Publish to Maven Registry:**
  ```bash
  ./gradlew publish
  ```
  *Note: Requires `dc.username` and `dc.password` to be set in `gradle.properties` or as environment variables.*

- **Check for Dependency Updates:**
  ```bash
  ./gradlew dependencyUpdates
  ```

- **Update Version Catalog:**
  ```bash
  ./gradlew versionCatalogUpdate
  ```

## Development Conventions

### Kotlin Contracts
When adding new "check" or "assertion" style functions, always use `ExperimentalContracts` to provide the compiler with `returns() implies ...` hints. This ensures that the call site doesn't require redundant null checks or boolean assertions.

### Internal API Protection
Use the `@InternalProxyObject` annotation for properties or functions that are technically public (due to inline constraints or reflection needs) but should not be used by external consumers. It requires an explicit `@OptIn(InternalProxyObject::class)`.

### Target Support
Ensure that core logic remains in `commonMain` to maintain portability across all supported platforms (JVM, JS, Wasm, Native). Use `expect`/`actual` or platform-specific source sets (like `jvmMain`) only when platform-specific APIs (like `kotlin.reflect`) are necessary.

### Dependencies
Dependencies are managed via the Version Catalog in `gradle/libs.versions.toml`. Use the `libs` alias when adding new dependencies to `build.gradle.kts`.
