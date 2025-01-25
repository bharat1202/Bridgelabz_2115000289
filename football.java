import java.util.Scanner;
public class football {
public static void main(String[] args) {
double[] heights = new double[11];
double sum = 0.0;
Scanner scanner = new Scanner(System.in);
System.out.println("Enter the heights of 11 players:");
for (int i = 0; i < heights.length; i++) {
System.out.print("Enter height for player " + (i + 1) + ": ");
heights[i] = scanner.nextDouble();
sum += heights[i];
}
double meanHeight = sum / heights.length;
System.out.println("The mean height of the football team is: " +meanHeight);
scanner.close();
}
}
