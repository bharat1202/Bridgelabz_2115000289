import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilterJsonExample {
    public static void main(String[] args) {
        try {
            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON file
            JsonNode rootArray = objectMapper.readTree(new File("data.json"));

            // List to store filtered records
            List<JsonNode> filteredRecords = new ArrayList<>();

            // Loop through JSON array and filter records where age > 25
            for (JsonNode node : rootArray) {
                if (node.get("age").asInt() > 25) {
                    filteredRecords.add(node);
                }
            }

            // Convert filtered list to JSON string
            String filteredJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredRecords);

            // Print filtered JSON
            System.out.println(filteredJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
