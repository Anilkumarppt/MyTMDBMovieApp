package com.example.mytmdbmovieapp.presentation.navigation

sealed class MovieAppScreen(val route:String){

    object MainScreen: MovieAppScreen("main_screen")
    object DetailScreen: MovieAppScreen("detail_screen")
    object SearchScreen: MovieAppScreen("search_screen")

    fun withArgs(vararg args:Int):String{

        return buildString {
            append(route)
            args.forEach {
                arg->append("/$arg")
            }
        }
    }

}
