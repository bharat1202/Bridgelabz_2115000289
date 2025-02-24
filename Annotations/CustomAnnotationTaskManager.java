import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

// Class using the custom annotation
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Aman")
    public void completeTask() {
        System.out.println("Task completed.");
    }
}

// Retrieving annotation details using Reflection API
public class CustomAnnotationTaskManager {
    public static void main(String[] args) throws Exception {
        Method method = taskManager.class.getMethod("completeTask");

        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
            System.out.println("Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }
    }
}
