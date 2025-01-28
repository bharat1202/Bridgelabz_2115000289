import java.util.Scanner;
public class NumberChecker {
// Method to check if the number is positive or negative
public static boolean isPositive(int number) {
return number >= 0;
}
// Method to check if the number is even or odd
public static String isEven(int number) {
return (number % 2 == 0) ? "Even" : "Odd";
}
// Method to compare two numbers and return 1 if number1 > number2, 0 if bothare equal, or -1 if number1 < number2
public static int compare(int number1, int number2) {
if (number1 > number2) {
return 1; // number1 is greater
} else if (number1 == number2) {
return 0; // numbers are equal
} else {
return -1; // number1 is smaller
}
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Array to store the 5 numbers
int[] numbers = new int[5];
// Get input for 5 numbers
for (int i = 0; i < 5; i++) {

System.out.print("Enter number " + (i + 1) + ": ");
numbers[i] = scanner.nextInt();
}
// Check each number if it is positive or negative
for (int i = 0; i < numbers.length; i++) {
if (isPositive(numbers[i])) {
System.out.println(numbers[i] + " is positive and " +isEven(numbers[i]) + ".");
} else {
System.out.println(numbers[i] + " is negative.");
}
}
// Compare the first and last elements of the array
int comparisonResult = compare(numbers[0], numbers[4]);
if (comparisonResult == 1) {
System.out.println("The first number is greater than the last number.");
} else if (comparisonResult == 0) {
System.out.println("The first number is equal to the last number.");
} else {
System.out.println("The first number is less than the last number.");
}
}
}
