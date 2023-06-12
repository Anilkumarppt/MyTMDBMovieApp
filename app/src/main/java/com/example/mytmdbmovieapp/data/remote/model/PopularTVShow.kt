package com.impressico.moviesapp.data.remote.model

import com.example.mytmdbmovieapp.domain.model.PopularListDto

data class PopularTVShow(
    var backdrop_path: String,
    val first_air_date: String,
    val genre_ids: List<Int>,
    val id: Int,
    val name: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    var poster_path: String,
    val vote_average: Double,
    val vote_count: Int
){
    fun toPopularListDto(): PopularListDto {
        return PopularListDto(name,id,backdrop_path,poster_path,first_air_date,vote_average,overview)
    }
}
