import java.util.Random;
import java.util.Scanner;
public class StudentScorecard {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the number of students: ");

int students = scanner.nextInt();
int[][] scores = generateScores(students);
double[][] results = calculateTotalAveragePercentage(scores);
displayScorecard(scores, results);
scanner.close();
}
// Generate random scores for Physics, Chemistry, and Math
public static int[][] generateScores(int students) {
Random rand = new Random();
int[][] scores = new int[students][3]; // [Physics, Chemistry, Math]
for (int i = 0; i < students; i++) {
scores[i][0] = rand.nextInt(41) + 60; // Physics: 60-100
scores[i][1] = rand.nextInt(41) + 60; // Chemistry: 60-100
scores[i][2] = rand.nextInt(41) + 60; // Math: 60-100
}
return scores;
}
// Calculate total, average, and percentage
public static double[][] calculateTotalAveragePercentage(int[][] scores) {
int students = scores.length;
double[][] results = new double[students][3]; // [Total, Average,Percentage]
for (int i = 0; i < students; i++) {
int total = scores[i][0] + scores[i][1] + scores[i][2];
double average = total / 3.0;
double percentage = (total / 300.0) * 100;
results[i][0] = total;
results[i][1] = Math.round(average * 100.0) / 100.0; // Round to 2decimals
results[i][2] = Math.round(percentage * 100.0) / 100.0; // Round to 2decimals
}
return results;
}
// Determine grade based on percentage
public static String getGrade(double percentage) {
if (percentage >= 80) return "A";

else if (percentage >= 70) return "B";
else if (percentage >= 60) return "C";
else if (percentage >= 50) return "D";
else if (percentage >= 40) return "E";
else return "R";
}
// Display scorecard
public static void displayScorecard(int[][] scores, double[][] results) {
System.out.println("----------------------------------------------------------------------------");
System.out.printf("%-5s %-8s %-8s %-8s %-8s %-8s %-8s %-5s%n", "ID","Physics", "Chemistry", "Math", "Total", "Average", "Percentage", "Grade");
System.out.println("----------------------------------------------------------------------------");
for (int i = 0; i < scores.length; i++) {
double percentage = results[i][2];
String grade = getGrade(percentage);
System.out.printf("%-5d %-8d %-8d %-8d %-8.0f %-8.2f %-8.2f %-5s%n",i + 1, scores[i][0], scores[i][1], scores[i][2], results[i][0],results[i][1], percentage, grade);
}
System.out.println("----------------------------------------------------------------------------");
}
}
