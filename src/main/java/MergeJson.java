import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class MergeJsonExample {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the two JSON files
            JsonNode json1 = objectMapper.readTree(new File("file1.json"));
            JsonNode json2 = objectMapper.readTree(new File("file2.json"));

            // Merge JSON objects
            JsonNode mergedJson = mergeJson(json1, json2);

            // Convert merged JSON to a string
            String mergedJsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson);

            // Print the merged JSON
            System.out.println(mergedJsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to merge two JSON objects
    private static JsonNode mergeJson(JsonNode mainNode, JsonNode updateNode) {
        if (mainNode.isObject() && updateNode.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = updateNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                ((com.fasterxml.jackson.databind.node.ObjectNode) mainNode).set(field.getKey(), field.getValue());
            }
        }
        return mainNode;
    }
}
