import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonExample {
    public static void main(String[] args) {
        try {
            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Define two JSON objects as strings
            String json1 = "{ \"name\": \"John Doe\", \"email\": \"john.doe@example.com\" }";
            String json2 = "{ \"age\": 30, \"city\": \"New York\" }";

            // Convert strings to JsonNode
            JsonNode node1 = objectMapper.readTree(json1);
            JsonNode node2 = objectMapper.readTree(json2);

            // Merge JSON objects
            ObjectNode mergedNode = objectMapper.createObjectNode();
            mergedNode.setAll((ObjectNode) node1);
            mergedNode.setAll((ObjectNode) node2);

            // Convert merged JSON to string and print
            String mergedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode);
            System.out.println(mergedJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
