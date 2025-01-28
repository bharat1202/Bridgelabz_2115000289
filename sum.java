import java.util.Scanner;
public class sum {
// Method to calculate the sum using recursion
public static int sumUsingRecursion(int n) {
// Base case: when n is 0, the sum is 0
if (n == 0) {
return 0;
}
// Recursive case: sum of n natural numbers is n + sum of (n-1) naturalnumbers
return n + sumUsingRecursion(n - 1);
}
// Method to calculate the sum using the formula n*(n+1)/2
public static int sumUsingFormula(int n) {
return (n * (n + 1)) / 2;
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

// Get input from the user for the number
System.out.print("Enter a natural number: ");
int n = scanner.nextInt();
// Check if the number is a valid natural number (greater than 0)
if (n <= 0) {
System.out.println("Please enter a positive integer.");
return;
}
// Calculate the sum using both methods
int sumRecursion = sumUsingRecursion(n);
int sumFormula = sumUsingFormula(n);
// Display the results
System.out.println("Sum of the first " + n + " natural numbers (usingrecursion): " + sumRecursion);
System.out.println("Sum of the first " + n + " natural numbers (usingformula): " + sumFormula);
// Compare the results
if (sumRecursion == sumFormula) {
System.out.println("Both methods give the correct and same result.");
} else {
System.out.println("There is an error in the results.");
}
}
}
