package me.salai.codingchallenges.exportformats;

/**
 * Interface Exporter
 * Declares the list of common functions required for a Export Format
 */
public interface Exporter {
    public void export();
    public String getExporterName();
}
