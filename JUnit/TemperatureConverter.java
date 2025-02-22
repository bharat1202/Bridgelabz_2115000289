import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TemperatureConverter {
    static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}

public class TemperatureConverterTest {
   
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0), 0.01);
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100), 0.01);
    }

    
    void testFahrenheitToCelsius() {
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32), 0.01);
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212), 0.01);
    }
}
