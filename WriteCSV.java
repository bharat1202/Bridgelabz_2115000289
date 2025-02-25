import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "C:\Users\bhara\Desktop\employees.csv";
        writeCSV(filePath);
    }

    public static void writeCSV(String filePath) {
       
        String[] employees = {
            "ID,Name,Department,Salary",
            "101,John Doe,IT,70000",
            "102,Jane Smith,HR,65000",
            "103,Emily Johnson,Finance,72000",
            "104,Michael Brown,Marketing,68000",
            "105,Chris Wilson,Engineering,75000"
        };

        try (FileWriter writer = new FileWriter(filePath)) {
            for (String employee : employees) {
                writer.write(employee + "\n");
            }
            System.out.println("CSV file written successfully: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
