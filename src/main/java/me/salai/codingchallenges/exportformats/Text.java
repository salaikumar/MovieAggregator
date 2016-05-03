package me.salai.codingchallenges.exportformats;
import me.salai.codingchallenges.movies.Movie;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.SynchronousQueue;


public class Text implements Exporter {

    public String export(String content,String pathToDir) {

        // Handle Corner Cases
        if (content.isEmpty() || pathToDir.isEmpty() ){
            throw new RuntimeException("Exporter requires Content and Directory Path");
        }

        //Check if pathToDir is a valid path
        File dir = new File(pathToDir);
        if( (!dir.isDirectory()) || (!dir.canWrite())){
            throw new RuntimeException("Directory Path does not exists or can't be written");
        }

        String fileName = "movies_" + System.currentTimeMillis() +".txt";
        File output = new File ( pathToDir + File.separator + fileName ) ;
        try {
            output.createNewFile();
            FileWriter fw = new FileWriter(output);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            return null; // Now I don't see a long trace.
        }
        return output.getAbsolutePath();
    }

    public String getExporterName() {
        return this.getClass().getSimpleName();
    }
}
