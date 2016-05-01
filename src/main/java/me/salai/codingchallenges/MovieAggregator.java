package me.salai.codingchallenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Movie Aggregator Class
 * Collects the movie information from user and export it to the format as user expects
 */
public class MovieAggregator {
    Set<Movie> movies;

    public boolean addMovie(Movie movie){
        return movies.add(movie);
    }

    public List<Movie> getAllMovies(){
        List<Movie> moviesList = new ArrayList<Movie>();
        movies.addAll(movies);
        return moviesList;
    }

    // --FixME Add more functions as requirement grows here

}
