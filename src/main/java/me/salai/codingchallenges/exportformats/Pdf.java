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
 * Pdf Class
 * Exports the given Movies to a Pdf
 */
public class Pdf implements Exporter {


    public void export(List<Movie> movies) {
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

        System.out.println("File Location:" + fileName  );
    }

    public String getExporterName() {
        return "Pdf";
    }
}
