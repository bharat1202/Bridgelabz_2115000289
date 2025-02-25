import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCSVRecords {
    public static void main(String[] args) {
        String filePath = "C:\Users\bhara\Desktop\students.csv"; 
        filterStudents(filePath);
    }

    public static void filterStudents(String filePath) {
        String line;
        boolean isHeader = true; // To skip the header row

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }

                // Split CSV values by comma
                String[] data = line.split(",");
                int marks = Integer.parseInt(data[3]); // Convert marks to integer

                // Filter and print students with marks > 80
                if (marks > 80) {
                    System.out.println("ID: " + data[0] + ", Name: " + data[1] + 
                                       ", Age: " + data[2] + ", Marks: " + data[3]);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
