package com.example.mytmdbmovieapp.data.remote

import com.example.mytmdbmovieapp.data.remote.NetworkResult
import com.impressico.moviesapp.data.remote.model.*

interface PopularRemoteDataSource {
    suspend fun getPopularMovies(page:Int): NetworkResult<PopularMovie>
    suspend fun getPopularMovieDetails(movieId:Int): NetworkResult<Movie>

    suspend fun getPopularTVShows(page: Int): NetworkResult<PopularTVResult>

    suspend fun getPopularTVShowDetails(tvshowId:Int): NetworkResult<PopularTVItem>
}