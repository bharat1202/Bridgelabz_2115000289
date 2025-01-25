import java.util.Scanner;
public class voting {
public static void main(String[] args) {
int[] studentAges = new int[10];
Scanner scanner = new Scanner(System.in);
System.out.println("Enter the ages of 10 students:");
for (int i = 0; i < studentAges.length; i++) {
studentAges[i] = scanner.nextInt();
}
for (int age : studentAges) {
if (age < 0) {
System.out.println("Invalid age.");
} else if (age >= 18) {
System.out.println("The student with the age " + age + " canvote.");
} else {
System.out.println("The student with the age " + age + " cannotvote.");
}
}
scanner.close();
}
}
