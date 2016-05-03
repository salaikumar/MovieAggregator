package me.salai.codingchallenges.exportformats;

import me.salai.codingchallenges.movies.Movie;

import java.util.List;

/**
 * Interface Exporter
 * Declares the list of common functions required for a Export Format
 */
public interface Exporter {
    public String export(String content, String pathToDir);
    public String getExporterName();
}
