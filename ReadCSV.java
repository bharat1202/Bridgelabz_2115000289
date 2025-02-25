import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
        String filePath = "C:\Users\bhara\Desktop\students.csv"; 
        readCSV(filePath);
    }

    public static void readCSV(String filePath) {
        String line;
        boolean isHeader = true; 

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split CSV values by comma
                String[] data = line.split(",");

                // Print structured output
                System.out.println("ID: " + data[0] + ", Name: " + data[1] + 
                                   ", Age: " + data[2] + ", Marks: " + data[3]);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
