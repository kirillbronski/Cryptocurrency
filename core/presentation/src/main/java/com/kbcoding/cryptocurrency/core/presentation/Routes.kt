package com.kbcoding.cryptocurrency.core.presentation

import androidx.navigation.NavBackStackEntry
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
data object RouteCoins

@Serializable
data object RouteFavorite

@Serializable
data class RouteCoinDetail(val coinId: String, val coinName: String)

fun NavBackStackEntry?.routeClass(): KClass<*>? {
    return this?.destination?.route
        ?.split("/")
        ?.first()
        ?.let { Class.forName(it) }
        ?.kotlin
}