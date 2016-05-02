# MovieAggregator
Console app that accepts movie details and export it to various formats such as PDF, Textfile.
## How to use
### Execution
```Java
   mvn clean package
   java -jar target/MovieAggregator-1.0-SNAPSHOT.jar 
```
### Adding your own ExportFormat
Create your own ExportFormat class, implementing Exporter interface. Package it under exportformats.
  ```Java
  public interface Exporter {
    public void export(List<Movie> movies); // Implement your exportformat under this method.
    public String getExporterName();        // Return your ExportFormat class name .
  }
  ```
### Sample Output
   ```
   salaikumar@Manikandan:~/WebApps/MovieAggregator$ java -jar target/MovieAggregator-1.0-SNAPSHOT.jar 
   Please Provide Movie details at each per line
   Example: World War X, 02:13:30, English, Brad Bit, Action
   Type 'exit' in order to exit
   World War X, 02:13:30, English, Brad Bit, Action
   World War X, 02:13:30, English, Brad Bit, Action
   World War X, 02:13:30, English, Brad Bit, Action
   World War X, 02:13:30, English, Brad Bit, Action
   World War X, 02:13:30, English, Brad Bit, Action
   World War X, 02:13:30, English, Brad Bit, Action
   exit
   Choose an Export Format
   Text
   Pdf
   PDF
   File Location:/home/salaikumar/movies_1462164264521.pdf
   ```
### How it works
1. The Export Formats classes and interfaces are organized under *exportformats* package. 
    Any new ExportFormat should implement *Exporter* interface. 
2. ClientProgram is the MainClass. The list of Export formats supported are first identified and made available for use
3. Once the user provides the data and types *exit* in a newline,the list of export options is displayed
4. Using *Reflection*, the instance of the Exporter chosen by user is created and export() is called.
5. Feel free to add your own ExportFormat class to *exportformats* package, clean and build the package and execute the jar.
   Your Exportformat would be available to user for use.


  



