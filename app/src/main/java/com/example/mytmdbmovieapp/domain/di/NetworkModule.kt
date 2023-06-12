package com.example.mytmdbmovieapp.domain.di

import com.google.gson.GsonBuilder
import com.example.mytmdbmovieapp.data.AuthInterceptor
import com.example.mytmdbmovieapp.data.NetworkConstants.BASE_URL
import com.example.mytmdbmovieapp.data.NetworkConstants.CONNECT_TIMEOUT
import com.example.mytmdbmovieapp.data.NetworkConstants.READ_TIMEOUT
import com.example.mytmdbmovieapp.data.NetworkConstants.WRITE_TIMEOUT
import com.example.mytmdbmovieapp.data.remote.PopularRemoteDataSource
import com.example.mytmdbmovieapp.data.remote.PopularRemoteDataSourceImpl
import com.example.mytmdbmovieapp.data.remote.RemoteDataSource
import com.example.mytmdbmovieapp.data.remote.apiservice.TMDBMovieApiService
import com.example.mytmdbmovieapp.data.repositoryImpl.PopularMovieRepoImpl
import com.example.mytmdbmovieapp.data.repositoryImpl.PopularTVShowRepoImpl
import com.example.mytmdbmovieapp.domain.repository.PopularMovieRepo
import com.example.mytmdbmovieapp.domain.repository.PopularTVShowRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(authInterceptor: AuthInterceptor):OkHttpClient{
        val loggingInterceptor: HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient().newBuilder().addInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptor)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit.Builder {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(okHttpClient)
    }
    @Provides
    @Singleton
    fun provideMovieAPI(retrofit: Retrofit.Builder): TMDBMovieApiService {
        return retrofit.build().create(TMDBMovieApiService::class.java)
    }
    @Provides
    @Singleton
    fun provideRemoteSource(): RemoteDataSource = RemoteDataSource()

    @Provides
    @Singleton
    fun providesPopularRemoteDataSource(tmdbMovieApiService: TMDBMovieApiService, remoteDataSource: RemoteDataSource): PopularRemoteDataSource =
        PopularRemoteDataSourceImpl(tmdbMovieApiService, remoteDataSource)
    @Provides
    @Singleton
    fun providePopularMoviesRepo(popularRemoteData: PopularRemoteDataSource): PopularMovieRepo =
        PopularMovieRepoImpl(popularRemoteData)

    @Provides
    @Singleton
    fun providePopularTVShow(popularRemoteData: PopularRemoteDataSource): PopularTVShowRepo =
        PopularTVShowRepoImpl(popularRemoteData)
}