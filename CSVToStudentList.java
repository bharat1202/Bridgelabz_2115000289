import java.io.*;
import java.util.*;

public class CSVToStudentList {
    public static void main(String[] args) {
        String filePath = "C:\Users\bhara\Desktop\students.csv"; // CSV file path
        List<Student> students = readStudentsFromCSV(filePath);

        // Print all student objects
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> readStudentsFromCSV(String filePath) {
        List<Student> studentList = new ArrayList<>();
        String line;
        boolean isHeader = true; // Skip the header row

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // Skip header
                }

                String[] data = line.split(",");
                if (data.length == 4) { // Ensure correct column count
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    double marks = Double.parseDouble(data[3].trim());

                    // Create Student object and add to list
                    studentList.add(new Student(id, name, age, marks));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing CSV: " + e.getMessage());
        }

        return studentList;
    }
}
