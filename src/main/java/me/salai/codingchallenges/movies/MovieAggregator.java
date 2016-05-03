package me.salai.codingchallenges.movies;

import me.salai.codingchallenges.movies.Movie;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Movie Aggregator Class
 * Collects the movie information from user and export it to the format as user expects
 */
public class MovieAggregator {
    private List<Movie> movies;
    private final String newLineChar = System.getProperty("line.separator");

    public MovieAggregator(){
        movies = new ArrayList<Movie>();
    }

    public MovieAggregator(List<Movie> movies){
        this.movies = movies;
    }

    public boolean addMovie(Movie movie){
        return movies.add(movie);
    }

    public List<Movie> getAllMovies(){
        return movies;
    }

    @Override
    public String toString(){
        StringBuilder text = new StringBuilder();
        for (Movie movie : movies){
            text.append(movie.toString() + newLineChar);
        }
        return  new String(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieAggregator that = (MovieAggregator) o;

        if (!movies.equals(that.movies)) return false;
        return newLineChar != null ? newLineChar.equals(that.newLineChar) : that.newLineChar == null;

    }

    @Override
    public int hashCode() {
        return movies.hashCode();
    }
}
