import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

// Class with annotated methods
class PerformanceTest {

    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Fast method executed.");
    }

    @LogExecutionTime
    public void slowMethod() {
        try {
            Thread.sleep(1000);
            System.out.println("Slow method executed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Aspect to measure execution time
public class ExecutionTimeLogger {
    public static void main(String[] args) throws Exception {
        for (Method method : PerformanceTest.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(new PerformanceTest());
                long end = System.nanoTime();
                System.out.println("Execution Time: " + (end - start) / 1_000_000 + " ms");
            }
        }
    }
}
