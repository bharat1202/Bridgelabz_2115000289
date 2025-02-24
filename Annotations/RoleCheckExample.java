import java.lang.annotation.*;

// Define @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

// Simulating role check
class SecureService {

    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed.");
    }
}

// Role validation
public class RoleCheckExample {
    public static void main(String[] args) throws Exception {
        String userRole = "USER"; // Change to "ADMIN" to pass check

        Method method = SecureService.class.getMethod("adminTask");
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            String requiredRole = method.getAnnotation(RoleAllowed.class).value();
            if (userRole.equals(requiredRole)) {
                method.invoke(new SecureService());
            } else {
                System.out.println("Access Denied!");
            }
        }
    }
}
