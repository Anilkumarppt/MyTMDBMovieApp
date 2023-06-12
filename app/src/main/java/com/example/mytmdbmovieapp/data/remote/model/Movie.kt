package com.impressico.moviesapp.data.remote.model

import com.example.mytmdbmovieapp.domain.model.PopularListDto

data class Movie(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: BelongsToCollection,
    val budget: Int,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
){
fun toPopularListDto(): PopularListDto {
    return PopularListDto(title,id,backdrop_path,poster_path,release_date,vote_average,overview)
}
}