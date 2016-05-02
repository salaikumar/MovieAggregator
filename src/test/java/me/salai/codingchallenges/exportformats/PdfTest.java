package me.salai.codingchallenges.exportformats;

import me.salai.codingchallenges.movies.Movie;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
        Movie movie1 = new Movie("World War X", "02:13:30", "English", "Brad Bit", "Action");
        Movie movie2 = new Movie("World War A", "02:13:30", "English", "Brad Bit", "Action");
        Movie movie3 = new Movie("World War B", "02:13:30", "English", "Brad Bit", "Action");
        Movie movie4 = new Movie("World War C", "02:13:30", "English", "Brad Bit", "Action");
        Movie movie5 = new Movie("World War Z", "02:13:30", "English", "Brad Bit", "Action");
        Movie movie6 = new Movie("sample", "02:13:30", "English", "Brad Bit", "Action");
        List<Movie> movies= new ArrayList<Movie>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);

        Exporter exporter = new Text();
        String file = exporter.export(movies);
        assertThat(file.isEmpty(),is(false));
    }

}