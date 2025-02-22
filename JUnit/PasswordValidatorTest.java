import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class PasswordValidator {
    static boolean isValid(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*\\d.*");
    }
}

public class PasswordValidatorTest {
    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Password1"));
    }

    @Test
    void testInvalidPasswordShort() {
        assertFalse(PasswordValidator.isValid("Pass1"));
    }

    @Test
    void testInvalidPasswordNoUppercase() {
        assertFalse(PasswordValidator.isValid("password1"));
    }

    @Test
    void testInvalidPasswordNoDigit() {
        assertFalse(PasswordValidator.isValid("Password"));
    }
}
