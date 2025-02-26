import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ReadJsonExample {
    public static void main(String[] args) {
        try {
            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON file
            JsonNode rootNode = objectMapper.readTree(new File("data.json"));

            // Extract specific fields
            String name = rootNode.get("name").asText();
            String email = rootNode.get("email").asText();

            // Print extracted fields
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
