import java.io.*;
import java.util.*;

public class DetectDuplicatesCSV {
    public static void main(String[] args) {
        String filePath = "C:\Users\bhara\Desktop\students.csv"; // CSV file with duplicate IDs
        detectDuplicates(filePath);
    }

    public static void detectDuplicates(String filePath) {
        Map<Integer, String> recordMap = new HashMap<>(); // Stores unique records
        Set<Integer> duplicateIds = new HashSet<>(); // Stores duplicate IDs
        String line;
        boolean isHeader = true;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 2) { // Ensure there are enough columns
                    System.out.println("Invalid row: " + line);
                    continue;
                }

                int id = Integer.parseInt(data[0].trim());

                // Check for duplicates
                if (recordMap.containsKey(id)) {
                    duplicateIds.add(id); // Mark as duplicate
                } else {
                    recordMap.put(id, line); // Store unique record
                }
            }

            // Print duplicate records
            if (duplicateIds.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records:");
                for (int id : duplicateIds) {
                    System.out.println(recordMap.get(id)); // Print the first occurrence
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
