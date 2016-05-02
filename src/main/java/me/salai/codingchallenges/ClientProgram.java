package me.salai.codingchallenges;

import me.salai.codingchallenges.exportformats.ExportFormat;
import me.salai.codingchallenges.exportformats.Exporter;
import me.salai.codingchallenges.exportformats.Pdf;
import me.salai.codingchallenges.exportformats.Text;
import me.salai.codingchallenges.movies.Movie;
import me.salai.codingchallenges.movies.MovieAggregator;

import java.util.List;
import java.util.Scanner;

/**
 * Client Program
 */
public class ClientProgram {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        MovieAggregator movieAggregator = new MovieAggregator();
        ExportFormat exportFormat = new ExportFormat();

        // Add the formats u want the system to support.
        exportFormat.addExportFormat(new Text()); // => Export to text.
        exportFormat.addExportFormat(new Pdf()); // => Export to Pdf

        // Print Statements for User input
        System.out.println("Please Provide Movie details at each per line. Type exit at End");
        System.out.println("Example: World War X, 02:13:30, English, Brad Bit, Action");
        while(scanner.hasNextLine()){
            String input = scanner.nextLine();
            if ( input.equalsIgnoreCase("exit"))
                break;
            String[] movieDetails = input.split(",");
            Movie movie = new Movie(movieDetails[0],movieDetails[1],movieDetails[2],movieDetails[3],movieDetails[4]);
            movieAggregator.addMovie(movie);
        }

        System.out.println("Choose an Export Format");
        List<Exporter> exporters = exportFormat.getExportFormats();
        for (Exporter exp : exporters)
            System.out.println(exp.getExporterName());

        // Make it as a proper class name
        String inputClass = scanner.nextLine().toLowerCase();
        String firstLetter = String.valueOf(inputClass.charAt(0)).toUpperCase();
        String expClass = firstLetter + inputClass.substring(1,inputClass.length());

        //  Export it to the user desired format
        Exporter chosenExporter = exportFormat.getExporter(expClass);
        chosenExporter.export(movieAggregator.getAllMovies());
    }
}
