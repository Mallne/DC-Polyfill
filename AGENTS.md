# Polyfill

**Stack**: KMP utility library. Contracts, extensions, validation.

> **Full docs**: [polyfill/.ai/](.ai/) | [Notary](https://docs.mallne.cloud/doc/polyfill-uC5ggFQ9CY)

## Critical Rules

1. New check/assertion functions must use `ExperimentalContracts` for compiler hints
2. Use `@InternalProxyObject` for public APIs that external consumers must not use
3. Keep all logic in `commonMain` -- platform-specific code breaks cross-platform builds
4. Use `expect`/`actual` only when platform APIs (like `kotlin.reflect`) are required

## Build

```bash
./gradlew build
./gradlew test
./gradlew jvmTest
```
