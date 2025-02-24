import java.lang.annotation.*;
import java.lang.reflect.Method;

// Container annotation to hold multiple BugReports
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Define the repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class) // Enables multiple usage
@interface BugReport {
    String description();
    String reportedBy();
}

// Class using the repeatable annotation
class IssueTracker {

    @BugReport(description = "NullPointerException when input is null", reportedBy = "Alice")
    @BugReport(description = "IndexOutOfBoundsException for empty list", reportedBy = "Bob")
    public void processTask() {
        System.out.println("Processing task...");
    }
}

// Main class to retrieve and print annotations
public class BugRepor{
    public static void main(String[] args) throws Exception {
        Method method = IssueTracker.class.getMethod("processTask");

        // Retrieve repeatable annotations
        if (method.isAnnotationPresent(BugReport.class) || method.isAnnotationPresent(BugReports.class)) {
            BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);
            for (BugReport bug : bugReports) {
                System.out.println("Bug Description: " + bug.description());
                System.out.println("Reported By: " + bug.reportedBy());
                System.out.println("----------------------");
            }
        }
    }
}
