import java.util.ArrayList;
public class NumberChecker6 {
// Method to find factors of a number and return them as an array
public static int[] findFactors(int number) {
// Count the factors
int count = 0;
for (int i = 1; i <= number; i++) {
if (number % i == 0) count++;
}
// Store the factors in an array

int[] factors = new int[count];
int index = 0;
for (int i = 1; i <= number; i++) {
if (number % i == 0) {
factors[index++] = i;
}
}
return factors;
}
// Method to find the greatest factor of a number
public static int findGreatestFactor(int[] factors) {
int greatest = factors[0];
for (int factor : factors) {
if (factor > greatest) {
greatest = factor;
}
}
return greatest;
}
// Method to find the sum of the factors
public static int findSumOfFactors(int[] factors) {
int sum = 0;
for (int factor : factors) {
sum += factor;
}
return sum;
}
// Method to find the product of the factors
public static int findProductOfFactors(int[] factors) {
int product = 1;
for (int factor : factors) {
product *= factor;
}
return product;
}
// Method to find the product of the cube of the factors
public static double findProductOfCubes(int[] factors) {
double product = 1;
for (int factor : factors) {
product *= Math.pow(factor, 3);
}

return product;
}
// Method to check if a number is a perfect number
public static boolean isPerfectNumber(int number) {
int[] factors = findFactors(number);
int sum = 0;
for (int factor : factors) {
if (factor != number) { // Proper divisors exclude the number itself
sum += factor;
}
}
return sum == number;
}
// Method to check if a number is an abundant number
public static boolean isAbundantNumber(int number) {
int[] factors = findFactors(number);
int sum = 0;
for (int factor : factors) {
if (factor != number) { // Proper divisors exclude the number itself
sum += factor;
}
}
return sum > number;
}
// Method to check if a number is a deficient number
public static boolean isDeficientNumber(int number) {
int[] factors = findFactors(number);
int sum = 0;
for (int factor : factors) {
if (factor != number) { // Proper divisors exclude the number itself
sum += factor;
}
}
return sum < number;
}
// Method to check if a number is a strong number
public static boolean isStrongNumber(int number) {
int originalNumber = number;
int sum = 0;
while (number > 0) {
int digit = number % 10;
sum += factorial(digit);
number /= 10;
}
return sum == originalNumber;
}
// Helper method to calculate factorial
private static int factorial(int number) {
int fact = 1;
for (int i = 1; i <= number; i++) {
fact *= i;
}
return fact;
}
public static void main(String[] args) {
int number = 28; // Example number
// Find factors
int[] factors = findFactors(number);
System.out.print("Factors: ");
for (int factor : factors) {
System.out.print(factor + " ");
}
System.out.println();
// Find greatest factor
int greatestFactor = findGreatestFactor(factors);
System.out.println("Greatest Factor: " + greatestFactor);
// Find sum of factors
int sumOfFactors = findSumOfFactors(factors);
System.out.println("Sum of Factors: " + sumOfFactors);
// Find product of factors
int productOfFactors = findProductOfFactors(factors);
System.out.println("Product of Factors: " + productOfFactors);
// Find product of cube of factors
double productOfCubes = findProductOfCubes(factors);
System.out.println("Product of Cube of Factors: " + productOfCubes);
// Check for perfect number

boolean isPerfect = isPerfectNumber(number);
System.out.println("Is Perfect Number: " + isPerfect);
// Check for abundant number
boolean isAbundant = isAbundantNumber(number);
System.out.println("Is Abundant Number: " + isAbundant);
// Check for deficient number
boolean isDeficient = isDeficientNumber(number);
System.out.println("Is Deficient Number: " + isDeficient);
// Check for strong number
boolean isStrong = isStrongNumber(number);
System.out.println("Is Strong Number: " + isStrong);
}
}
