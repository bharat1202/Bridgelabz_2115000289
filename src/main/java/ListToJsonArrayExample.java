import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ListToJsonArrayExample {
    public static void main(String[] args) {
        try {
            // Creating a list of Car objects
            List<Car> cars = Arrays.asList(
                    new Car("Toyota", "Corolla", 2022),
                    new Car("Honda", "Civic", 2021),
                    new Car("Ford", "Mustang", 2023)
            );

            // Convert List to JSON Array
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(cars);

            // Print JSON Array
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
