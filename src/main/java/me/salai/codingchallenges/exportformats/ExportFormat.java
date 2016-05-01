package me.salai.codingchallenges.exportformats;

import me.salai.codingchallenges.exportformats.Exporter;

import java.util.ArrayList;
import java.util.List;

/**
 * ExportFormats
 * Holds all types of ExportFormats supported in the application
 */
public class ExportFormat {
    List<Exporter> exportFormats;

    public ExportFormat(){
        exportFormats = new ArrayList<Exporter>();
    }

    public void addExportFormat(Exporter exporter){
        exportFormats.add(exporter);
    }

    public List<Exporter> getExportFormats(){
        return exportFormats;
    }

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
