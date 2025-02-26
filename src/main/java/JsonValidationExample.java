import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValidationExample {
    public static void main(String[] args) {
        String validJson = "{ \"name\": \"John Doe\", \"email\": \"john.doe@example.com\" }";
        String invalidJson = "{ \"name\": \"John Doe\", \"email\": 123 }"; // Invalid type for email

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Validate JSON by converting it to a User object
            User user = objectMapper.readValue(validJson, User.class);
            System.out.println("Valid JSON: " + user.getName() + ", " + user.getEmail());
        } catch (Exception e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }

        try {
            // This will fail due to incorrect data type
            User user = objectMapper.readValue(invalidJson, User.class);
            System.out.println("Valid JSON: " + user.getName() + ", " + user.getEmail());
        } catch (Exception e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}
