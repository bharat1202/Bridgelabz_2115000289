import java.lang.annotation.*;
import java.util.HashMap;
import java.util.Map;

// Define @CacheResult annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

// Caching logic
class ExpensiveOperation {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int square(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int result = n * n;
        cache.put(n, result);
        return result;
    }
}

// Test caching
public class CachingExample {
    public static void main(String[] args) {
        ExpensiveOperation op = new ExpensiveOperation();
        System.out.println(op.square(5)); // Computes
        System.out.println(op.square(5)); // Returns cached value
    }
}
