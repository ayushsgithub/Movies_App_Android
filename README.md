
# Movie App 🎥

An Android application that fetches and displays popular movies from The Movie Database (TMDb) API using **Retrofit** and **RecyclerView**.

## Features

- Fetches a list of popular movies from TMDb API.
- Displays movie posters and titles in a grid layout.
- Supports dynamic content loading using Retrofit for network requests.
- Simple and clean UI using Material Design components.
- Error handling for network failures.

## Built With

- **Retrofit** - For handling HTTP requests to fetch data from the API.
- **Gson** - For converting JSON responses into Kotlin data classes.
- **RecyclerView** - To display the movie data in a grid layout.
- **StaggeredGridLayoutManager** - For laying out movie items in a staggered grid.
- **Glide** - For loading movie posters efficiently.

## API Reference

This app fetches data from [The Movie Database (TMDb) API](https://www.themoviedb.org/documentation/api). You need to register for an API key and use it to access the movie data.

### Project Structure

The app consists of activities, adapters, and data models structured to efficiently fetch and display movie data.

![screenshot](https://github.com/ayushsgithub/Movies_App_Android/blob/main/app/images/Screenshot%202024-09-28%20164349.png?raw=true)

### How It Works

- The app fetches a list of popular movies using Retrofit from the TMDb API.
- Movies are displayed in a **RecyclerView** in a grid layout with their posters and titles.
- Retrofit handles the network request, and Glide efficiently loads movie images.

## Acknowledgments

- [TMDb API](https://www.themoviedb.org/) for providing movie data.
- [Retrofit](https://square.github.io/retrofit/) for simplifying network operations.
- [Glide](https://bumptech.github.io/glide/) for efficient image loading.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
