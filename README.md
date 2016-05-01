# MovieAggregator
Console app that accepts movie details and export it to various formats such as PDF, Textfile.
## How to use
### Execution


### Adding your own ExportFormat
1. Create your own ExportFormat class, implementing Exporter interface. Package it under exportformats.

  ```Java
  public interface Exporter {
    public void export(List<Movie> movies); // Implement your exportformat under this method.
    public String getExporterName();        // Return your ExportFormat class name .
  }
  ```
2. Add it to ExportFormat Class in your Client Program

  ```Java
  ExportFormat exportFormat = new ExportFormat();
  // Add the formats u want the system to support.
  exportFormat.addExportFormat(new Text()); // => Export to text
  exportFormat.addExportFormat(new Pdf()); // => Export to Pdf
  ```
  



