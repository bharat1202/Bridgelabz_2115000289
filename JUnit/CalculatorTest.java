
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }


    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
    }


    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
    }


    void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
    }


    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(6, 0);
        });
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
