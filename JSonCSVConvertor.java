import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.*;
import java.util.*;

public class JsonCsvConverter {
    public static void main(String[] args) {
        String jsonFile = "students.json";
        String csvFile = "C:\Users\bhara\Desktop\students.csv";
        String outputJsonFile = "converted_students.json";

        // Convert JSON to CSV
        jsonToCsv(jsonFile, csvFile);

        // Convert CSV back to JSON
        csvToJson(csvFile, outputJsonFile);
    }

    // Convert JSON to CSV
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, Object>> students = objectMapper.readValue(new File(jsonFile), new TypeReference<>() {});

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
                if (!students.isEmpty()) {
                    // Write CSV Header
                    Set<String> headers = students.get(0).keySet();
                    writer.write(String.join(",", headers));
                    writer.newLine();

                    // Write Data
                    for (Map<String, Object> student : students) {
                        List<String> values = new ArrayList<>();
                        for (String header : headers) {
                            values.add(String.valueOf(student.getOrDefault(header, "")));
                        }
                        writer.write(String.join(",", values));
                        writer.newLine();
                    }
                }
            }
            System.out.println("JSON successfully converted to CSV: " + csvFile);
        } catch (IOException e) {
            System.err.println("Error converting JSON to CSV: " + e.getMessage());
        }
    }

    // Convert CSV to JSON
    public static void csvToJson(String csvFile, String outputJsonFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            List<Map<String, Object>> students = new ArrayList<>();
            String[] headers = br.readLine().split(","); // Read CSV header

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, Object> student = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    student.put(headers[i], values[i].trim());
                }
                students.add(student);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputJsonFile), students);

            System.out.println("CSV successfully converted back to JSON: " + outputJsonFile);
        } catch (IOException e) {
            System.err.println("Error converting CSV to JSON: " + e.getMessage());
        }
    }
}
