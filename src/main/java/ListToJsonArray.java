import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ListToJsonArrayExample {
    public static void main(String[] args) {
        try {
            // Create a list of Person objects
            List<Person> people = Arrays.asList(
                    new Person("Alice", 28, "New York"),
                    new Person("Bob", 32, "Los Angeles"),
                    new Person("Charlie", 25, "Chicago")
            );

            // Convert List to JSON Array
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(people);

            // Print JSON Array
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
