import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Define @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

// User class using @JsonField
class User {
    @JsonField(name = "user_name")
    private String username;

    public User(String username) {
        this.username = username;
    }
}

// Convert object to JSON
public class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        Map<String, String> jsonMap = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                jsonMap.put(field.getAnnotation(JsonField.class).name(), field.get(obj).toString());
            }
        }
        return jsonMap.toString();
    }

    public static void main(String[] args) throws Exception {
        User user = new User("AmanGupta");
        System.out.println(toJson(user)); // Output: { "user_name": "AmanGupta" }
    }
}
