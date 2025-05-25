package com.kbcoding.cryptocurrency.core.presentation

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kbcoding.cryptocurrency.core.presentation.ui.theme.TextWhite
import kotlin.reflect.KClass

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Coins,
        BottomNavItem.Favorites,
        BottomNavItem.Profile
    )

    BottomNavigation(
        modifier = Modifier.navigationBarsPadding(),
        backgroundColor =  MaterialTheme.colorScheme.primary,
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value.routeClass()
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.title, tint = TextWhite) },
                label = { Text(item.title, color = TextWhite) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(route = item.route.java.name) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}


sealed class BottomNavItem(val route: KClass<*>, val icon: ImageVector, val title: String) {
    data object Coins : BottomNavItem(RouteCoins::class, Icons.Default.List, "Coins")
    data object Favorites : BottomNavItem(RouteFavorite::class, Icons.Default.Favorite, "Favorites")
    data object Profile : BottomNavItem(RouteCoins::class, Icons.Default.Person, "Profile")
}