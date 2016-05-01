package me.salai.codingchallenges.exportformats;
import me.salai.codingchallenges.movies.Movie;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * Exports the list of movies to a text file
 */
public class Text implements Exporter {

    /*
     * Export the movies to a Text File
     */
    public void export(List<Movie> movies) {
        String userDirPath = System.getProperty("user.home");
        String fileName = "movies_" + System.currentTimeMillis() +".txt";
        File output = new File(userDirPath + "/" + fileName);
        try {
            output.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add contents to the file.
        try {
            FileWriter fw = new FileWriter(output);
            for ( Movie mov : movies){
                fw.write(mov.toString());
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getExporterName() {
        return "Text";
    }
}
