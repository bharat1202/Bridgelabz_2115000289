import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define @Todo annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

// Class using @Todo
class Project {

    @Todo(task = "Implement login", assignedTo = "Aman", priority = "HIGH")
    public void loginFeature() {}

    @Todo(task = "Improve UI", assignedTo = "John", priority = "LOW")
    public void improveUI() {}
}

// Retrieve and print TODO annotations
public class TodoAnnotationExample {
    public static void main(String[] args) {
        for (Method method : Project.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task() + ", Assigned To: " + todo.assignedTo() + ", Priority: " + todo.priority());
            }
        }
    }
}
