import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCSVRows {
    public static void main(String[] args) {
        String filePath = "C:\Users\bhara\Desktop\employees.csv";
        int recordCount = countRows(filePath);
        System.out.println("Total records (excluding header): " + recordCount);
    }

    public static int countRows(String filePath) {
        int count = 0;
        boolean isHeader = true;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while (br.readLine() != null) {
                if (isHeader) { 
                    isHeader = false; 
                    continue;
                }
                count++; 
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return count;
    }
}
