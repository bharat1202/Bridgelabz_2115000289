import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberUtils {
    static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

class PerformanceTest {
    void longRunningTask() throws InterruptedException {
        Thread.sleep(3000);
    }
}

public class NumberUtilsTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 7, 9})
    void testIsEven(int number) {
        boolean expected = (number % 2 == 0);
        assertEquals(expected, NumberUtils.isEven(number), "Number should be correctly identified as even or odd");
    }

    @Test
    @Timeout(2)
    void testLongRunningTask() throws InterruptedException {
        new PerformanceTest().longRunningTask();
    }
}
