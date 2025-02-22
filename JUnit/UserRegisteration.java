import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class UserRegistration {
    void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
    }
}

public class UserRegistrationTest {
    private UserRegistration userRegistration;

    @BeforeEach
    void setUp() {
        userRegistration = new UserRegistration();
    }

    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> userRegistration.registerUser("JohnDoe", "john@example.com", "Password1"));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("", "john@example.com", "Password1"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("JohnDoe", "johnexample.com", "Password1"));
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("JohnDoe", "john@example.com", "pass"));
    }
}
