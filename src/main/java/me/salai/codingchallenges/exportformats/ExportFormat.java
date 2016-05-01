package me.salai.codingchallenges.exportformats;

import me.salai.codingchallenges.exportformats.Exporter;

import java.util.ArrayList;
import java.util.List;

/**
 * Export Formats
 * All types of Export Formats are present here for use.
 */
public class ExportFormat {
    List<Exporter> exportFormats;

    public ExportFormat(){
        exportFormats = new ArrayList<Exporter>();
    }
    // Add a new Exported. -- In order to know the list of types in which the data can be exported
    public void addExportFormat(Exporter exporter){
        exportFormats.add(exporter);
    }

    // return all ExportFormats
    public List<Exporter> getExportFormats(){
        return exportFormats;
    }

    // return the instance of a exporter
    public Exporter getExporter(String className){
        Exporter exporter = null;
        try {
            exporter = (Exporter) Class.forName("me.salai.codingchallenges.exportformats"+"."+className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return exporter;
    }


}
