package com.plcoding.cryptocurrencyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.cryptocurrencyapp.presentation.coin_list.ui.CoinDetailScreen
import com.plcoding.cryptocurrencyapp.presentation.coin_list.ui.CoinListScreen
import com.plcoding.cryptocurrencyapp.presentation.screen.Screen
import com.plcoding.cryptocurrencyapp.presentation.ui.theme.CryptocurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = Screen.CoinListScreen.route
                        ) {
                            composable(
                                route = Screen.CoinListScreen.route
                            ) {
                                CoinListScreen(navController)
                            }
                            composable(
                                route = Screen.CoinDetailScreen.route + "/{coinId}"
                            ) {
                                CoinDetailScreen()
                            }
                    }
                }
            }
        }
    }
}