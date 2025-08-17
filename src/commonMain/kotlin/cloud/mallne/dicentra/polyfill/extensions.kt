package cloud.mallne.dicentra.polyfill

operator fun <T> Boolean.invoke(block: ()->T): T? {
    return if (this) {
        block()
    } else {
        null
    }
}

operator fun Boolean.invoke(block: ()->Unit) {
    if (this) {
        block()
    }
}