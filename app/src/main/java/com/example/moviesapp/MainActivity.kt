package com.example.moviesapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.moviesapp.api.ApiMovie
import com.example.moviesapp.api.ApiMovieList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var rvHome: RecyclerView
    lateinit var movieAdapter: MovieAdapter
    val moviesList = mutableListOf<ApiMovie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHome = findViewById(R.id.rvHome)
        rvHome.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        // Initialize adapter and set it to RecyclerView
        movieAdapter = MovieAdapter(this, moviesList)
        rvHome.adapter = movieAdapter

        // Fetch movies
        fetchMovies()
    }

    private fun fetchMovies() {
        // Create Retrofit instance
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create API service
        val movieApiService = retrofit.create(MovieApiService::class.java)

        // Make network call
        movieApiService.getMovies().enqueue(object : Callback<ApiMovieList> {
            override fun onResponse(call: Call<ApiMovieList>, response: Response<ApiMovieList>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        moviesList.clear()
                        moviesList.addAll(it.results)
                        movieAdapter.notifyDataSetChanged()
                    }
                }
            }
            override fun onFailure(call: Call<ApiMovieList>, t: Throwable) {
                // Log the error message
                Log.e("MainActivity", "Failed to fetch movies: ${t.message}")

                // Show a toast message to the user
                Toast.makeText(this@MainActivity, "Failed to fetch movies. Please try again.", Toast.LENGTH_SHORT).show()

            }

        })
    }
}

