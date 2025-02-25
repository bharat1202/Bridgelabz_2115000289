import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployee {
    public static void main(String[] args) {
        String filePath = "C:\Users\bhara\Desktop\employees.csv"; 
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine();
        
        searchEmployee(filePath, searchName);
        scanner.close();
    }

    public static void searchEmployee(String filePath, String searchName) {
        String line;
        boolean isHeader = true; // Skip header row
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header
                    continue;
                }

                // Split CSV values by comma
                String[] data = line.split(",");
                String name = data[1]; // Employee name column

                // Check if the name matches (case-insensitive)
                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("Employee Found!");
                    System.out.println("Department: " + data[2]);
                    System.out.println("Salary: $" + data[3]);
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }
}
