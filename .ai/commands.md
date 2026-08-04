# Commands and Environment -- Polyfill

## Scripts

```bash
# Build all targets
./gradlew build

# Run all tests
./gradlew test

# Run JVM-specific tests
./gradlew jvmTest

# Publish to Maven registry
./gradlew publish

# Check for dependency updates
./gradlew dependencyUpdates

# Update version catalog
./gradlew versionCatalogUpdate
```

## Local Dev Setup

1. Ensure JDK 21 is installed (configured as toolchain)
2. Run `./gradlew build` from the `polyfill/` directory
3. Run `./gradlew test` to verify all targets pass

## Environment Variables

| Variable | Purpose | Default |
|----------|---------|---------|
| `dc.username` | Maven registry username (for publish) | Required for publish |
| `dc.password` | Maven registry password (for publish) | Required for publish |

## Runtime Notes

- Publishing requires `dc.username` and `dc.password` in `gradle.properties` or as environment variables.
