package com.example.moviesapp.api

data class ApiMovieList(
    val page: Int,
    val results: List<ApiMovie>,
    val total_pages: Int,
    val total_results: Int
)
