package me.salai.codingchallenges.exportformats;

import me.salai.codingchallenges.movies.Movie;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.List;

/**
 * Exports the movies to PDF
 */
public class PDF implements Exporter {

    // Export as PDF
    public void export(List<Movie> movies) {
        // Prepare the movie details as as a single string
//        StringBuilder str = new StringBuilder();
//        for (Movie movie : movies){
//            str.append(movie.toString());
//            str.append(System.lineSeparator());
//        }
//        String movieDetails = new String(str);
        String userDirPath = System.getProperty("user.home");
        String fileName = userDirPath + "/"+ "movies_" + System.currentTimeMillis() +".pdf";
        PDDocument  doc= new PDDocument();
        try{
            PDPage page = new PDPage();
            doc.addPage(page);
            PDFont font = PDType1Font.HELVETICA_BOLD;
            PDPageContentStream contents = new PDPageContentStream(doc, page);
            int x = 0;
            int y = 780;
            for (Movie movie : movies) {
                contents.beginText();
                contents.setFont(font, 10);
                contents.newLineAtOffset(x, y);
                contents.showText(movie.toString());
                contents.endText();
                y -= 15;
            }
            contents.close();
            doc.save(fileName);
            doc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getExporterName() {
        return "PDF";
    }
}
