import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // SQL query to fetch user data
            String query = "SELECT id, name, age, email FROM users";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Store database records in a list
            List<Map<String, Object>> userList = new ArrayList<>();
            while (rs.next()) {
                Map<String, Object> userRecord = new HashMap<>();
                userRecord.put("id", rs.getInt("id"));
                userRecord.put("name", rs.getString("name"));
                userRecord.put("age", rs.getInt("age"));
                userRecord.put("email", rs.getString("email"));
                userList.add(userRecord);
            }

            // Convert to JSON using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userList);

            // Print the JSON report
            System.out.println(jsonOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
