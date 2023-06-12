package com.example.mytmdbmovieapp.domain.repository

import com.example.mytmdbmovieapp.data.remote.NetworkResult
import com.impressico.moviesapp.data.remote.model.Movie
import com.impressico.moviesapp.data.remote.model.PopularMovie
import kotlinx.coroutines.flow.Flow

interface PopularMovieRepo {

    suspend fun getPopularMovies():Flow<NetworkResult<PopularMovie>>
    suspend fun getPopularMovieDetails(movieId:Int):Flow<NetworkResult<Movie>>
}