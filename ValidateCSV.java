import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "C:\Users\bhara\Desktop\employees.csv"; 
        validateCSVData(filePath);
    }

    public static void validateCSVData(String filePath) {
        String line;
        boolean isHeader = true;
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"; // Email format
        String phoneRegex = "^\\d{10}$"; // 10-digit phone number format

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 5) { // Ensure there are enough columns
                    System.out.println("Invalid row (missing data): " + line);
                    continue;
                }

                String email = data[3].trim(); // Assuming Email is at index 3
                String phone = data[4].trim(); // Assuming Phone is at index 4

                Matcher emailMatcher = emailPattern.matcher(email);
                Matcher phoneMatcher = phonePattern.matcher(phone);

                if (!emailMatcher.matches()) {
                    System.out.println("Invalid email: " + email + " in row: " + line);
                }

                if (!phoneMatcher.matches()) {
                    System.out.println("Invalid phone number: " + phone + " in row: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
