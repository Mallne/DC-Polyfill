package cloud.mallne.dicentra.polyfill

object Validation {
    object Null {
        fun exactly(count: Int, vararg properties: Any?) =
            properties.count { it != null } == count

        fun atLeast(count: Int, vararg properties: Any?) =
            properties.count { it != null } >= count

        fun atMost(count: Int, vararg properties: Any?) =
            properties.count { it != null } <= count

        fun oneOrNone(vararg properties: Any?) = atMost(1, *properties)
        fun none(vararg properties: Any?) = exactly(0, *properties)
        fun one(vararg properties: Any?) = exactly(1, *properties)
    }

    object Bool {
        fun exactly(count: Int, vararg properties: Boolean, toBe: Boolean = true) =
            properties.count { it == toBe } == count

        fun atLeast(count: Int, vararg properties: Boolean, toBe: Boolean = true) =
            properties.count { it == toBe } >= count

        fun atMost(count: Int, vararg properties: Boolean, toBe: Boolean = true) =
            properties.count { it == toBe } <= count

        fun oneOrNone(vararg properties: Boolean, toBe: Boolean = true) =
            atMost(1, toBe = toBe, properties = properties)

        fun none(vararg properties: Boolean, toBe: Boolean = true) = exactly(0, toBe = toBe, properties = properties)
        fun one(vararg properties: Boolean, toBe: Boolean = true) = exactly(1, toBe = toBe, properties = properties)
    }

}