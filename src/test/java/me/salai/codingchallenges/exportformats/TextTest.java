package me.salai.codingchallenges.exportformats;

import me.salai.codingchallenges.movies.Movie;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Text Exporter to Pdf
 */
public class TextTest {

    @Test
    public void shouldTestTextExport(){
        Movie movie1 = new Movie("World War X", "02:13:30", "English", "Brad Bit", "Action");
        Movie movie2 = new Movie("World War A", "02:13:30", "English", "Brad Bit", "Action");
        Movie movie3 = new Movie("World War B", "02:13:30", "English", "Brad Bit", "Action");
        Movie movie4 = new Movie("World War C", "02:13:30", "English", "Brad Bit", "Action");
        Movie movie5 = new Movie("World War Z", "02:13:30", "English", "Brad Bit", "Action");
        List<Movie> movies= new ArrayList<Movie>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);

        Exporter exporter = new Text();
        String file = exporter.export(movies);
        assertThat(file.isEmpty(),is(false));
        try {
            assertThat(FileUtils.readFileToString(new File(file)).contains(movie1.toString()),is(true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Movie movie6 = new Movie("American Gangster", "02:13:30", "English", "Brad Bit", "Action");
        try {
            assertThat(FileUtils.readFileToString(new File(file)).contains(movie6.toString()),is(false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}