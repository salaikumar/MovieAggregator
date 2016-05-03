package me.salai.codingchallenges.movies;

import me.salai.codingchallenges.exportformats.PdfTest;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class MovieAggregatorTest {
    @Test
    public void shouldTestMovieAggregator(){
        MovieAggregator  movieAggregator = new MovieAggregator(PdfTest.getTestMovieList());
        assertThat(movieAggregator.getAllMovies().size(),is(5));

        String toPrintData = movieAggregator.toString();
        Movie movie1 = new Movie("Fight Club", "02:13:30", "English", "Brad pitt", "Action");
        Movie movie2 = new Movie("Fight Club22222", "02:13:30", "English", "Brad pitt", "Action");
        assertThat(toPrintData.contains(movie1.toString()),is(true));
        assertThat(toPrintData.contains(movie2.toString()),is(false));
    }
}