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
   ```java
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

  



