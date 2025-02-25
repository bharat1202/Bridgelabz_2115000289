import java.io.*;
import java.util.*;

class Student {
    int id;
    String name;
    int age;
    double marks;
    String grade;

    public Student(int id, String name, int age, double marks, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "C:\Users\bhara\Desktop\students1.csv";  
        String file2 = "C:\Users\bhara\Desktop\students2.csv";  
        String outputFile = "merged_students.csv"; 

        mergeCSVFiles(file1, file2, outputFile);
    }

    public static void mergeCSVFiles(String file1, String file2, String outputFile) {
        Map<Integer, Student> studentMap = new HashMap<>();
        String line;

        
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; 
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 3) {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());

                    studentMap.put(id, new Student(id, name, age, 0, ""));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading " + file1 + ": " + e.getMessage());
        }

        
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; 
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 3) {
                    int id = Integer.parseInt(data[0].trim());
                    double marks = Double.parseDouble(data[1].trim());
                    String grade = data[2].trim();

                    
                    if (studentMap.containsKey(id)) {
                        Student student = studentMap.get(id);
                        student.marks = marks;
                        student.grade = grade;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading " + file2 + ": " + e.getMessage());
        }

        // Write merged data to a new CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade"); // Header
            bw.newLine();
            for (Student student : studentMap.values()) {
                bw.write(student.toString());
                bw.newLine();
            }
            System.out.println("Merged file saved as: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing merged file: " + e.getMessage());
        }
    }
}
