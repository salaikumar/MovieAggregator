package me.salai.codingchallenges;

import me.salai.codingchallenges.exportformats.ExportFormat;
import me.salai.codingchallenges.exportformats.Exporter;
import me.salai.codingchallenges.exportformats.Pdf;
import me.salai.codingchallenges.exportformats.Text;
import me.salai.codingchallenges.movies.Movie;
import me.salai.codingchallenges.movies.MovieAggregator;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.vfs.SystemDir;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Client Program
 */
public class ClientProgram {

    MovieAggregator movieAggregator;
    ExportFormat exportFormat ;

    public ClientProgram(){
        movieAggregator = new MovieAggregator();
        exportFormat    = new ExportFormat();
    }

    public void enableExporters(){
        Reflections reflections = new Reflections(ClasspathHelper.forPackage("me.salai.codingchallenges"));
        Set<Class<? extends Exporter>> exportClasses = reflections.getSubTypesOf(Exporter.class);
        for ( Class<? extends Exporter> ex : exportClasses){
            try {
                exportFormat.addExportFormat(ex.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public String exportFileToGivenFormat(String fileFormat){
        //  Export it to the user desired format
        Exporter chosenExporter = exportFormat.getExporter(fileFormat);
        return chosenExporter.export(movieAggregator.getAllMovies().toString(), System.getProperty("user.home"));
    }

    public static void main(String[] args){

        ClientProgram clientProgram = new ClientProgram();
        Scanner scanner = new Scanner(System.in);

        clientProgram.enableExporters();

        System.out.println("Please Provide Movie details at each per line");
        System.out.println("Example: World War X, 02:13:30, English, Brad Bit, Action");
        System.out.println("Type 'exit' in order to exit");

        while(scanner.hasNextLine()){
            String input = scanner.nextLine();
            if ( input.equalsIgnoreCase("exit"))
                break;
            String[] movieDetails = input.split(",");
            Movie movie = new Movie(movieDetails[0],movieDetails[1],movieDetails[2],movieDetails[3],movieDetails[4]);
            clientProgram.movieAggregator.addMovie(movie);
        }

        System.out.println("Choose an Export Format");
        List<Exporter> exporters = clientProgram.exportFormat.getExportFormats();
        for (Exporter exp : exporters)
            System.out.println(exp.getExporterName());

        String inputClass = scanner.nextLine().toLowerCase();
        String firstLetter = String.valueOf(inputClass.charAt(0)).toUpperCase();
        String expClass = firstLetter + inputClass.substring(1,inputClass.length());

        String outputFilePath = clientProgram.exportFileToGivenFormat(expClass);
        System.out.println("Output File:" + outputFilePath);
    }
}
