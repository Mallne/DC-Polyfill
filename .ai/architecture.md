# Architecture -- Polyfill

## Purpose

Polyfill is a KMP utility library providing contracts, extensions, and validation helpers for the DiCentra framework. It offers missing or enhanced utility functions that facilitate cleaner and more expressive Kotlin code.

## Tech Stack

- **Language:** Kotlin Multiplatform (KMP)
- **Contracts:** Kotlin Contracts for compiler optimization hints
- **Reflection:** kotlin.reflect (JVM-specific validation)
- **Build:** Gradle Kotlin DSL

## Project Structure

```
polyfill/
+-- src/
    +-- commonMain/           # Core utilities
    |   +-- contracts.kt      # ensure/probe with compiler contracts
    |   +-- extensions.kt     # Boolean.invoke operator, misc extensions
    |   +-- Validation.kt     # Null/Bool count checkers
    |   +-- InternalProxyObject.kt  # @InternalProxyObject annotation
    +-- jvmMain/              # JVM-specific extensions
        +-- Validation.kt     # Reflection-based property validation
```

## Key Components

- **Contracts** (`contracts.kt`): `ensure` and `probe` functions using Kotlin Contracts to inform the compiler about nullability and boolean conditions.
- **Extensions** (`extensions.kt`): `Boolean.invoke` operator and utility extensions.
- **Validation** (`Validation.kt`): Null/Bool count checkers in common; JVM adds reflection-based property validation.
- **@InternalProxyObject**: Annotation for public APIs that should not be used externally.

## Dependencies on Other Modules

- None (standalone utility library)

## Non-negotiable Rules

- Core logic must remain in `commonMain` for cross-platform portability
- Use `expect`/`actual` only when platform-specific APIs (like `kotlin.reflect`) are required
- Use `@InternalProxyObject` for properties/functions that are technically public but external-use is prohibited
