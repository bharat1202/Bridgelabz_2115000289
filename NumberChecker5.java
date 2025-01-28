public class NumberChecker5 {
// Method to check if a number is a prime number
public static boolean isPrime(int number) {
if (number <= 1) return false; // Prime numbers are greater than 1
for (int i = 2; i <= Math.sqrt(number); i++) {
if (number % i == 0) return false; // Divisible by any number other than1 and itself
}
return true;
}
// Method to check if a number is a neon number
public static boolean isNeonNumber(int number) {
int square = number * number;
int sumOfDigits = 0;
// Calculate the sum of digits of the square
while (square > 0) {
sumOfDigits += square % 10;
square /= 10;
}
return sumOfDigits == number;
}
// Method to check if a number is a spy number
public static boolean isSpyNumber(int number) {
int sumOfDigits = 0;
int productOfDigits = 1;
// Calculate the sum and product of digits
while (number > 0) {
int digit = number % 10;
sumOfDigits += digit;
productOfDigits *= digit;
number /= 10;
}
return sumOfDigits == productOfDigits;
}
// Method to check if a number is an automorphic number
public static boolean isAutomorphicNumber(int number) {
int square = number * number;
String numStr = String.valueOf(number);
String squareStr = String.valueOf(square);
// Check if the square ends with the number
return squareStr.endsWith(numStr);
}
// Method to check if a number is a buzz number
public static boolean isBuzzNumber(int number) {
return number % 7 == 0 || number % 10 == 7; // Divisible by 7 or ends with 7
}
public static void main(String[] args) {
int number = 7; // Example number
// Check if the number is a prime number
boolean isPrime = isPrime(number);
System.out.println("Is Prime Number: " + isPrime);
// Check if the number is a neon number
boolean isNeon = isNeonNumber(number);
System.out.println("Is Neon Number: " + isNeon);
// Check if the number is a spy number
boolean isSpy = isSpyNumber(number);
System.out.println("Is Spy Number: " + isSpy);

// Check if the number is an automorphic number
boolean isAutomorphic = isAutomorphicNumber(number);
System.out.println("Is Automorphic Number: " + isAutomorphic);
// Check if the number is a buzz number
boolean isBuzz = isBuzzNumber(number);
System.out.println("Is Buzz Number: " + isBuzz);
}
}
