package me.salai.codingchallenges.movies;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class MovieAggregatorTest {
    @Test
    public void shouldTestMovieAggregator(){
        Movie movie1 = new Movie("World War X", "02:13:30", "English", "Brad Bit", "Action");
        Movie movie2 = new Movie("World War A", "02:13:30", "English", "Brad Bit", "Action");
        Movie movie3 = new Movie("World War B", "02:13:30", "English", "Brad Bit", "Action");
        Movie movie4 = new Movie("World War C", "02:13:30", "English", "Brad Bit", "Action");
        Movie movie5 = new Movie("World War Z", "02:13:30", "English", "Brad Bit", "Action");
        MovieAggregator movieAggregator = new MovieAggregator();
        movieAggregator.addMovie(movie1);
        movieAggregator.addMovie(movie2);
        movieAggregator.addMovie(movie3);
        movieAggregator.addMovie(movie4);
        movieAggregator.addMovie(movie5);

        assertThat(movieAggregator.getAllMovies().size(),is(5));
    }
}