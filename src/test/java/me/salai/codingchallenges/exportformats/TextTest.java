package me.salai.codingchallenges.exportformats;

import me.salai.codingchallenges.movies.MovieAggregator;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Text Exporter to Pdf
 */
public class TextTest {

    @Test
    public void shouldTestTextExport(){
        MovieAggregator movies = new MovieAggregator(PdfTest.getTestMovieList());
        Exporter exporter = new Text();
        String fileName = exporter.export(movies.toString(),PdfTest.getHomeDirPath());
        assertThat(fileName.isEmpty(),is(false));
        assertThat(exporter.getExporterName(),is("Text"));
    }

}