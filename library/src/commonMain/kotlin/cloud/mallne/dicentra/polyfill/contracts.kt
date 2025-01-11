package cloud.mallne.dicentra.polyfill

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun ensure(
    value: Boolean,
    lazyMessage: () -> IllegalArgumentException
) {
    contract {
        returns() implies value
    }
    if (!value) {
        val message = lazyMessage()
        throw message
    }
}

@OptIn(ExperimentalContracts::class)
inline fun <T : Any> ensureNotNull(
    value: T?,
    lazyMessage: () -> IllegalArgumentException
): T {
    contract {
        returns() implies (value != null)
    }

    if (value == null) {
        val message = lazyMessage()
        throw message
    } else {
        return value
    }
}

@OptIn(ExperimentalContracts::class)
inline fun probe(
    value: Boolean,
    lazyMessage: () -> IllegalStateException
) {
    contract {
        returns() implies value
    }
    if (!value) {
        val message = lazyMessage()
        throw message
    }
}

@OptIn(ExperimentalContracts::class)
inline fun <T : Any> probeNotNull(
    value: T?,
    lazyMessage: () -> IllegalStateException
): T {
    contract {
        returns() implies (value != null)
    }

    if (value == null) {
        val message = lazyMessage()
        throw message
    } else {
        return value
    }
}