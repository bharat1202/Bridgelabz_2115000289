
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {
    StringUtils stringUtils = new StringUtils();


    void testReverse() {
        assertEquals("dcba", stringUtils.reverse("abcd"));
    }


    void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertFalse(stringUtils.isPalindrome("hello"));
    }

  void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
    }
}
