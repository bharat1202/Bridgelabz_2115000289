import java.util.Scanner;
public class StudentVoteChecker  {
// Method to check if the student can vote based on their age
public boolean canStudentVote(int age) {
// Validate the age (it should not be negative)
if (age < 0) {
return false; // Negative age means cannot vote
}
// If age is 18 or above, the student can vote
return age >= 18;
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Create an instance of StudentVoteChecker
StudentVoteChecker checker = new StudentVoteChecker();
// Define an array to store ages of 10 students
int[] studentAges = new int[10];
// Loop to take input for the age of 10 students
for (int i = 0; i < studentAges.length; i++) {
System.out.print("Enter age of student " + (i + 1) + ": ");
studentAges[i] = scanner.nextInt();
// Check if the student can vote using the canStudentVote method
if (checker.canStudentVote(studentAges[i])) {
System.out.println("Student " + (i + 1) + " can vote.");
} else {
System.out.println("Student " + (i + 1) + " cannot vote.");
}
}
}

}
