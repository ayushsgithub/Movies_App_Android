package com.example.moviesapp

import com.example.moviesapp.api.ApiMovieList
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiService  {
//    @GET("https://api.themoviedb.org/3/movie/popular?api_key=3e4e6775a71a4e213c6430b6f4cdb740")  // Replace with your actual endpoint
    @GET("popular?api_key=3e4e6775a71a4e213c6430b6f4cdb740")  // Replace with your actual endpoint

    fun getMovies(): Call<ApiMovieList>  // ApiMovieList contains the list of movies
}