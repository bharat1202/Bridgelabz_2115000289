import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.File;
import java.io.FileInputStream;

public class EmailValidationExample {
    public static void main(String[] args) {
        try {
            // Load JSON Schema
            FileInputStream schemaStream = new FileInputStream(new File("schema.json"));
            JSONObject schemaJson = new JSONObject(new JSONTokener(schemaStream));
            Schema schema = SchemaLoader.load(schemaJson);

            // Sample JSON Data (Valid)
            JSONObject validUser = new JSONObject()
                    .put("name", "Alice")
                    .put("email", "alice@example.com");

            // Sample JSON Data (Invalid)
            JSONObject invalidUser = new JSONObject()
                    .put("name", "Bob")
                    .put("email", "invalid-email"); // Missing '@' symbol

            // Validate JSON (Valid Case)
            try {
                schema.validate(validUser);
                System.out.println("✅ Valid JSON: " + validUser);
            } catch (Exception e) {
                System.out.println("❌ Validation Failed: " + e.getMessage());
            }

            // Validate JSON (Invalid Case)
            try {
                schema.validate(invalidUser);
                System.out.println("✅ Valid JSON: " + invalidUser);
            } catch (Exception e) {
                System.out.println("❌ Validation Failed: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
