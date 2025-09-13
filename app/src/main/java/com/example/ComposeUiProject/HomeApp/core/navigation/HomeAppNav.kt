package com.example.ComposeUiProject.HomeApp.core.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

import androidx.navigation.compose.rememberNavController
import com.example.ComposeUiProject.HomeApp.feature.splash.SplashScreen
import com.example.ComposeUiProject.R


@Composable
fun HomeAppNav() {
    val navController = rememberNavController()
    val backStack by navController.currentBackStackEntryAsState()
    val currentRoute = backStack?.destination?.route
    val showBottomBar = currentRoute in bottomDestinations.map { it.route }

    Scaffold(
        containerColor = colorResource(R.color.lightGreyHome),
        contentWindowInsets = WindowInsets(0),
    ) { inner ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(inner)
        ) {
            NavHost(
                navController = navController,
                startDestination = "splash",
                modifier = Modifier.fillMaxSize()
            ) {
                composable("splash") {
                    SplashScreen(onStartClick = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(route = "splash") { inclusive = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    })
                }
            }
        }
    }
}

sealed class Screen(val route: String, val icon: Int) {
    object Home : Screen("home", R.drawable.home_bottom_btn1)
    object Explorer : Screen("explorer", R.drawable.home_bottom_btn2)
    object Bookmark : Screen("bookmark", R.drawable.home_bottom_btn3)
    object Profile : Screen("profile", R.drawable.home_bottom_btn4)

}

private val bottomDestinations =
    listOf(
        Screen.Home,
        Screen.Explorer,
        Screen.Bookmark,
        Screen.Profile
    )

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDest = backStackEntry?.destination

    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(50.dp))
            .background(colorResource(R.color.black))
            .height(70.dp)
            .padding(4.dp),
        containerColor = Color.Transparent,
        tonalElevation = 0.dp
    ) {
        bottomDestinations.forEach { screen ->
            val selected = currentDest?.hierarchy?.any {
                it.route == screen.route
            } == true
            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }, icon = {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .background(if (selected) colorResource(R.color.blue) else Color.Transparent),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(screen.icon),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.Unspecified,
                )

            )
        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    val navController = rememberNavController()
    BottomBar(navController)
}