
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest2 {
    Calculator calculator = new Calculator();

   
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
