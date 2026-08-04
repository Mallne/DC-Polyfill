# Business Rules -- Polyfill

Rules an agent must respect when writing code for this module.

## Kotlin Contracts

- **Rule**: New "check" or "assertion" style functions must use `ExperimentalContracts` to provide compiler hints via `returns() implies ...`.
- **Why**: Eliminates redundant null checks and boolean assertions at call sites.

## Internal API Protection

- **Rule**: Use `@InternalProxyObject` for properties/functions that are technically public (due to inline constraints or reflection) but must not be used by external consumers.
- **Why**: External use of internal implementation details creates fragile coupling.

## Platform Portability

- **Rule**: Keep all logic in `commonMain`. Use `expect`/`actual` or platform-specific source sets only when platform APIs are absolutely necessary.
- **Why**: Polyfill is consumed by all modules across all platforms. Platform-specific code in `commonMain` breaks compilation.

## Edge Cases

- **Inline functions**: Some contract-using functions must be `inline`, which affects their visibility and call-site behavior.
- **JVM reflection**: Reflection-based validation is JVM-only and must not leak into `commonMain`.

## Overrides

- None. Polyfill follows root coding standards without module-specific overrides.
