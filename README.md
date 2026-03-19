# Dicentra Polyfill

[![Kotlin Multiplatform](https://img.shields.io/badge/Kotlin-Multiplatform-blue.svg?logo=kotlin)](https://kotlinlang.org/docs/multiplatform.html)
[![License](https://img.shields.io/badge/License-Apache%202.0-orange.svg)](LICENSE)

A Kotlin Multiplatform (KMP) utility library for the [DiCentra Application Framework](https://mallne.cloud). It provides essential polyfills, contracts, and validation helpers to make Kotlin development more expressive and safe across all platforms.

## ✨ Features

-   **Safe Checks:** `ensure` and `probe` functions with Kotlin Contracts for smarter static analysis.
-   **Validation Engine:** Flexible `Validation` DSL for both primitive types and JVM-reflected properties.
-   **Boolean DSL:** Invoke code blocks directly on boolean values for cleaner conditional logic.
-   **Multiplatform:** Seamless support for JVM, Android, JS, Wasm, iOS, and Linux targets.

## 🚀 Quick Start

Build the library for all targets:

```bash
./gradlew build
```

Check out `GEMINI.md` for detailed architectural notes and development guidelines.

## 📄 License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.
