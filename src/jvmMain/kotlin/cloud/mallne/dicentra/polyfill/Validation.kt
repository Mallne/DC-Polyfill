package cloud.mallne.dicentra.polyfill

import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties

@OptIn(InternalProxyObject::class)
inline fun <reified T : Any> Validation.Null.exactlyOf(count: Int, instance: T) =
    Validation.Null.exactly(count, *getProperties(instance))

@OptIn(InternalProxyObject::class)
inline fun <reified T : Any> Validation.Null.atLeastOf(count: Int, instance: T) =
    Validation.Null.atLeast(count, *getProperties(instance))

@OptIn(InternalProxyObject::class)
inline fun <reified T : Any> Validation.Null.atMostOf(count: Int, instance: T) =
    Validation.Null.atMost(count, *getProperties(instance))

@OptIn(InternalProxyObject::class)
inline fun <reified T : Any> Validation.Null.oneOrNoneOf(instance: T) = Validation.Null.oneOrNone(*getProperties(instance))

@OptIn(InternalProxyObject::class)
inline fun <reified T : Any> Validation.Null.noneOf(instance: T) = Validation.Null.none(*getProperties(instance))

@OptIn(InternalProxyObject::class)
inline fun <reified T : Any> Validation.Null.oneOf(instance: T) = Validation.Null.one(*getProperties(instance))

@InternalProxyObject
inline fun <reified T : Any> Validation.Null.getProperties(instance: T): Array<Any?> {
    val clazz: KClass<T> = T::class
    val members = clazz.declaredMemberProperties
    return members.map {
        it.get(instance)
    }.toTypedArray()
}

@OptIn(InternalProxyObject::class)
inline fun <reified T : Any> Validation.Bool.exactlyOf(count: Int, instance: T) =
    Validation.Bool.exactly(count, *getProperties(instance))

@OptIn(InternalProxyObject::class)
inline fun <reified T : Any> Validation.Bool.atLeastOf(count: Int, instance: T) =
    Validation.Bool.atLeast(count, *getProperties(instance))

@OptIn(InternalProxyObject::class)
inline fun <reified T : Any> Validation.Bool.atMostOf(count: Int, instance: T) =
    Validation.Bool.atMost(count, *getProperties(instance))

@OptIn(InternalProxyObject::class)
inline fun <reified T : Any> Validation.Bool.oneOrNoneOf(instance: T) = Validation.Bool.oneOrNone(*getProperties(instance))

@OptIn(InternalProxyObject::class)
inline fun <reified T : Any> Validation.Bool.noneOf(instance: T) = Validation.Bool.none(*getProperties(instance))

@OptIn(InternalProxyObject::class)
inline fun <reified T : Any> Validation.Bool.oneOf(instance: T) = Validation.Bool.one(*getProperties(instance))

@InternalProxyObject
inline fun <reified T : Any> Validation.Bool.getProperties(instance: T): BooleanArray {
    val clazz: KClass<T> = T::class
    val members = clazz.declaredMemberProperties
    return members.mapNotNull {
        val o = it.get(instance)
        o as? Boolean
    }.toBooleanArray()
}