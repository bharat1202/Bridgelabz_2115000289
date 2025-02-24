import java.lang.annotation.*;
import java.lang.reflect.Field;

// Define @MaxLength annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// User class applying @MaxLength
class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        if (username.length() > 10) {
            throw new IllegalArgumentException("Username exceeds max length!");
        }
        this.username = username;
    }
}

// Test validation
public class MaxLengthValidation {
    public static void main(String[] args) {
        new User("ShortName"); // Valid
        new User("VeryLongUsername"); // Throws exception
    }
}
