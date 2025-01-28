import java.util.Scanner;
public class factors {
// Method to find the factors of a number and return them in an array
public static int[] findFactors(int number) {
// First, count how many factors the number has
int count = 0;
for (int i = 1; i <= number; i++) {
if (number % i == 0) {
count++;
}
}
// Initialize the array with the size of the count of factors
int[] factors = new int[count];
// Second loop to store the factors in the array
int index = 0;
for (int i = 1; i <= number; i++) {
if (number % i == 0) {
factors[index] = i;
index++;
}
}
return factors;
}
// Method to find the sum of the factors
public static int findSum(int[] factors) {
int sum = 0;
for (int factor : factors) {
sum += factor;
}
return sum;
}
// Method to find the product of the factors
public static int findProduct(int[] factors) {
int product = 1;
for (int factor : factors) {
product *= factor;
}
return product;
}
// Method to find the sum of the square of the factors
public static double findSumOfSquares(int[] factors) {
double sumOfSquares = 0;
for (int factor : factors) {
sumOfSquares += Math.pow(factor, 2);
}
return sumOfSquares;
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Get input for the number
System.out.print("Enter a number: ");
int number = scanner.nextInt();
// Find the factors of the number
int[] factors = findFactors(number);
// Display the factors
System.out.print("Factors of " + number + " are: ");
for (int factor : factors) {
System.out.print(factor + " ");
}
System.out.println();
// Calculate and display the sum, product, and sum of squares of the factors
int sum = findSum(factors);
int product = findProduct(factors);
double sumOfSquares = findSumOfSquares(factors);
System.out.println("Sum of the factors: " + sum);
System.out.println("Product of the factors: " + product);
System.out.println("Sum of the square of the factors: " + sumOfSquares);
}
}
