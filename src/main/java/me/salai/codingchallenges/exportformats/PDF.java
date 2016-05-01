package me.salai.codingchallenges.exportformats;

import me.salai.codingchallenges.movies.Movie;

import java.util.List;

/**
 * Exports the movies to PDF
 */
public class PDF implements Exporter {
    public void export(List<Movie> movies) {

    }

    public String getExporterName() {
        return "PDF";
    }
}
