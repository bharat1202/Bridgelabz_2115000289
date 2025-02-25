import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFile = "C:\Users\bhara\Desktop\employees.csv";  
        String outputFile = "updated_employees.csv";  
        
        updateSalaries(inputFile, outputFile);
    }

    public static void updateSalaries(String inputFile, String outputFile) {
        List<String[]> records = new ArrayList<>();
        String line;
        boolean isHeader = true;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Skip header row but store it
                if (isHeader) {
                    isHeader = false;
                } else {
                    // Update salary if department is "IT"
                    if (data[2].equalsIgnoreCase("IT")) {
                        double salary = Double.parseDouble(data[3]);
                        salary *= 1.10; // Increase by 10%
                        data[3] = String.format("%.2f", salary); // Format to 2 decimal places
                    }
                }

                records.add(data); // Store updated record
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Write updated data to a new CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (String[] record : records) {
                bw.write(String.join(",", record));
                bw.newLine();
            }
            System.out.println("Updated file saved as: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
