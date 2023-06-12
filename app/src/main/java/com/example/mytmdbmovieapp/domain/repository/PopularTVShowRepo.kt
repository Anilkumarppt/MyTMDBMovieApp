package com.example.mytmdbmovieapp.domain.repository


import com.example.mytmdbmovieapp.data.remote.NetworkResult
import com.impressico.moviesapp.data.remote.model.PopularTVItem

import com.impressico.moviesapp.data.remote.model.PopularTVResult
import kotlinx.coroutines.flow.Flow

interface PopularTVShowRepo {
    suspend fun getPopularTVShows(): Flow<NetworkResult<PopularTVResult>>
    suspend fun getPopularTVShowDetails(tvshowId:Int): Flow<NetworkResult<PopularTVItem>>
}