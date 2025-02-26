import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Student {
    private String name;
    private int age;
    private List<String> subjects;

    // Constructor
    public Student(String name, int age, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    // Getters (required for Jackson)
    public String getName() { return name; }
    public int getAge() { return age; }
    public List<String> getSubjects() { return subjects; }
}

public class StudentJsonExample {
    public static void main(String[] args) {
        try {
            // Creating a Student object
            Student student = new Student("John Doe", 20, Arrays.asList("Math", "Physics", "Computer Science"));

            // Converting the Student object to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(student);

            // Printing the JSON output
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
