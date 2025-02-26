import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilterJsonExample {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file
            JsonNode rootArray = objectMapper.readTree(new File("users.json"));

            // List to store filtered users
            List<JsonNode> filteredUsers = new ArrayList<>();

            // Loop through JSON array and filter users older than 25
            for (JsonNode node : rootArray) {
                if (node.get("age").asInt() > 25) {
                    filteredUsers.add(node);
                }
            }

            // Convert filtered list to JSON string
            String filteredJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredUsers);

            // Print filtered JSON
            System.out.println(filteredJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
