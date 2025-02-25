import java.io.*;
import java.util.*;

public class SortCSV {
    public static void main(String[] args) {
        String filePath = "C:\Users\bhara\Desktop\employees.csv"; // CSV file path
        sortAndDisplayTopSalaries(filePath);
    }

    public static void sortAndDisplayTopSalaries(String filePath) {
        List<String[]> records = new ArrayList<>();
        String line;
        boolean isHeader = true;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                // Store header separately
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                records.add(data); // Store each record
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort records by Salary (index 3) in descending order
        records.sort((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));

        // Print the top 5 highest-paid employees
        System.out.println("Top 5 Highest-Paid Employees:");
        System.out.println("ID\tName\t\tDepartment\tSalary");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < Math.min(5, records.size()); i++) {
            String[] emp = records.get(i);
            System.out.printf("%s\t%s\t%s\t$%s\n", emp[0], emp[1], emp[2], emp[3]);
        }
    }
}
