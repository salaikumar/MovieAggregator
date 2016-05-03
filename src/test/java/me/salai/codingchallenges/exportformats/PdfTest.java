package me.salai.codingchallenges.exportformats;

import me.salai.codingchallenges.movies.Movie;
import me.salai.codingchallenges.movies.MovieAggregator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * PDF Unit test
 */
public class PdfTest {
    @Test
    public void shouldTestPDFExporter(){
        MovieAggregator movies = new MovieAggregator(getTestMovieList());
        Exporter exporter = new Pdf();
        String file = exporter.export(movies.toString(),getHomeDirPath());
        assertThat(file.isEmpty(),is(false));

        assertThat(exporter.getExporterName(),is("Pdf"));
    }

    public static List<Movie> getTestMovieList(){
        Movie movie1 = new Movie("Fight Club", "02:13:30", "English", "Brad pitt", "Action");
        Movie movie2 = new Movie("World War Z", "02:13:30", "English", "Brad pitt", "Action");
        Movie movie3 = new Movie("Troy", "02:13:30", "English", "Brad pitt", "Action");
        Movie movie4 = new Movie("Fury", "02:13:30", "English", "Brad pitt", "Action");
        Movie movie5 = new Movie("Moneyball", "02:13:30", "English", "Brad pitt", "Romance");
        List<Movie> movies= new ArrayList<Movie>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);

        return movies;
    }

    public static String getHomeDirPath(){
        return System.getProperty("user.home");
    }
}