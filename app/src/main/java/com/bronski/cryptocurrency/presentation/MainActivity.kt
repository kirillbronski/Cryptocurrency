package com.bronski.cryptocurrency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.kbcoding.cryptocurrency.core.presentation.AppToolbar
import com.kbcoding.cryptocurrency.core.presentation.BottomNavigationBar
import com.kbcoding.cryptocurrency.core.presentation.LocalNavController
import com.kbcoding.cryptocurrency.core.presentation.NavigateUpAction
import com.kbcoding.cryptocurrency.core.presentation.R
import com.kbcoding.cryptocurrency.core.presentation.RouteCoinDetail
import com.kbcoding.cryptocurrency.core.presentation.RouteCoins
import com.kbcoding.cryptocurrency.core.presentation.RouteFavorite
import com.kbcoding.cryptocurrency.core.presentation.routeClass
import com.kbcoding.cryptocurrency.core.presentation.ui.theme.CryptocurrencyThemeNew
import com.kbcoding.cryptocurrency.features.coindetail.presentation.coinDetailScreen.components.CoinDetailScreen
import com.kbcoding.cryptocurrency.fetures.coinlist.presentation.coinListScreen.components.CoinListScreen
import dagger.hilt.android.AndroidEntryPoint
import ru.scid.favorite.FavoriteScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptocurrencyThemeNew {
                Surface(color = MaterialTheme.colors.background) {
                    CryptocurrencyApp()
                }
            }
        }
    }
}

@Composable
fun CryptocurrencyApp() {

    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val titleRes = getTitleRes(currentBackStackEntry)

    Scaffold(
        topBar = {
            AppToolbar(
                titleRes = titleRes,
                navigateUpAction = if (navController.previousBackStackEntry == null) {
                    NavigateUpAction.Hidden
                } else {
                    NavigateUpAction.Visible(
                        onClick = { navController.navigateUp() }
                    )
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { paddingValues ->
        CompositionLocalProvider(
            value = LocalNavController provides navController
        ) {
            NavHost(
                navController = navController,
                startDestination = RouteCoins,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                composable<RouteCoins> { CoinListScreen() }
                composable<RouteCoinDetail> { navBackStackEntry ->
                    val route = navBackStackEntry.toRoute<RouteCoinDetail>()
                    CoinDetailScreen(route.coinId)
                }
                composable<RouteFavorite> { FavoriteScreen() }
            }
        }
    }
}

@Composable
private fun getTitleRes(currentBackStackEntry: NavBackStackEntry?): String {
    val titleRes = when (currentBackStackEntry.routeClass()) {
        RouteCoins::class -> stringResource(id = R.string.coins_title)
        RouteCoinDetail::class -> {
            val route = currentBackStackEntry?.toRoute<RouteCoinDetail>()
            route?.coinName ?: stringResource(id = R.string.coin_detail_title)
        }
        else -> stringResource(id = R.string.app_name)
    }
    return titleRes
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptocurrencyThemeNew {
        CoinListScreen()
    }
}