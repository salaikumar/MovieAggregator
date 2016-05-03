package me.salai.codingchallenges.exportformats;

import me.salai.codingchallenges.movies.Movie;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Pdf Class
 * Exports the given Movies to a Pdf
 */
public class Pdf implements Exporter {

    public String export(String content, String pathToDir) {
        // Handle Corner Cases
        if (content.isEmpty() || pathToDir.isEmpty() ){
            throw new RuntimeException("Exporter requires Content and Directory Path");
        }

        //Check if pathToDir is a valid path
        File dir = new File(pathToDir);
        if( (!dir.isDirectory()) || (!dir.canWrite())){
            throw new RuntimeException("Directory Path does not exists or can't be written");
        }

        String fileName = pathToDir + File.separator + "movies_" + System.currentTimeMillis() + ".pdf" ;
        String lines[] = content.split("\\r?\\n");
        try{
            PDDocument  doc= new PDDocument();
            PDPage page = new PDPage();
            doc.addPage(page);
            PDFont font = PDType1Font.HELVETICA_BOLD;
            PDPageContentStream contents = new PDPageContentStream(doc, page);
            int x = 0;
            int y = 780;
            for (String line: lines) {
                contents.beginText();
                contents.setFont(font, 10);
                contents.newLineAtOffset(x, y);
                contents.showText(line);
                contents.endText();
                y -= 15;
            }
            contents.close();
            doc.save(fileName);
            doc.close();
        } catch (IOException e) {
            return null;
        }
        return fileName;
    }

    public String getExporterName() {
        return this.getClass().getSimpleName();
    }

}
