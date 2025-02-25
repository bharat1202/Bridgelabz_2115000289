import java.io.*;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "C:\Users\bhara\Desktop\large_students.csv"; // Large CSV file path
        int chunkSize = 100; // Number of records to process per batch
        readCSVInChunks(filePath, chunkSize);
    }

    public static void readCSVInChunks(String filePath, int chunkSize) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int recordCount = 0;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }

                // Process the record (just counting in this case)
                recordCount++;

                // Display progress every 100 records
                if (recordCount % chunkSize == 0) {
                    System.out.println("Processed " + recordCount + " records...");
                }
            }

            System.out.println("Total records processed: " + recordCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
