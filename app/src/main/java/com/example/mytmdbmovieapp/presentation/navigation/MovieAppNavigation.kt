package com.example.mytmdbmovieapp.presentation.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.mytmdbmovieapp.presentation.MovieListScreen
import com.example.mytmdbmovieapp.presentation.viewmodel.PopularMovieViewModel
import com.example.mytmdbmovieapp.presentation.viewmodel.PopularTVShowViewModel

@ExperimentalMaterialApi
@Composable
fun MovieApp() {
    val navController = rememberNavController()

    val popularMovies: PopularMovieViewModel = viewModel()
    val tvShowListViewModel: PopularTVShowViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = MovieAppScreen.MainScreen.route
    ) {
        composable(route = MovieAppScreen.MainScreen.route) {
            MovieListScreen(navController = navController, moviesViewModel =popularMovies , tvShowViewModel = tvShowListViewModel )
        }

    }
}