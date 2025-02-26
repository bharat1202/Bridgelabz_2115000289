import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonKeysValues {
    public static void main(String[] args) {
        try {
            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON file
            JsonNode rootNode = objectMapper.readTree(new File("data.json"));

            // Print all keys and values
            printJson(rootNode, "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Recursive method to print JSON keys and values
    private static void printJson(JsonNode node, String parentKey) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                printJson(entry.getValue(), parentKey.isEmpty() ? entry.getKey() : parentKey + "." + entry.getKey());
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                printJson(node.get(i), parentKey + "[" + i + "]");
            }
        } else {
            System.out.println(parentKey + " : " + node.asText());
        }
    }
}
