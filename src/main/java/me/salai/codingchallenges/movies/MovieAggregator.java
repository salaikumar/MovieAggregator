package me.salai.codingchallenges.movies;

import me.salai.codingchallenges.movies.Movie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Movie Aggregator Class
 * Collects the movie information from user and export it to the format as user expects
 */
public class MovieAggregator {
    List<Movie> movies;

    public MovieAggregator(){
        movies = new ArrayList<Movie>();
    }
    public boolean addMovie(Movie movie){
        return movies.add(movie);
    }

    public List<Movie> getAllMovies(){
        return movies;
    }

    // --FixME Add more functions as requirement grows here

}
