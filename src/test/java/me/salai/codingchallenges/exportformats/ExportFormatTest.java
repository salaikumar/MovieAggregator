package me.salai.codingchallenges.exportformats;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Unit Tests for ExportFormat
 */
public class ExportFormatTest {

    @Test
    public void shouldTestExportFormatAllFunctions(){
        ExportFormat exportFormat = new ExportFormat();
        Exporter textExporter = new Text();
        Exporter pdfExporter  = new Pdf();
        exportFormat.addExportFormat(textExporter);
        exportFormat.addExportFormat(pdfExporter);
        Exporter textExporter2 = new Text();

        // Size check
        assertThat(exportFormat.getExportFormats().size(),is(2));

        // Export availability check
        assertThat(exportFormat.getExportFormats().contains(textExporter),is(true));
        assertThat(exportFormat.getExportFormats().contains(textExporter2),is(false));

        // Check if the given Exporter Instance is available is available.
        assertThat(exportFormat.getExporter("Text"),is(Exporter.class));
    }

}