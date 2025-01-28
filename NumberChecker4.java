public class NumberChecker4 {
// Method to find the count of digits in the number
public static int countDigits(int number) {
return String.valueOf(number).length();
}
// Method to store the digits of the number in an array
public static int[] storeDigitsInArray(int number) {
String numStr = String.valueOf(number);
int[] digits = new int[numStr.length()];
for (int i = 0; i < numStr.length(); i++) {
digits[i] = Character.getNumericValue(numStr.charAt(i));
}
return digits;
}
// Method to reverse the digits array
public static int[] reverseArray(int[] digits) {
int[] reversed = new int[digits.length];
for (int i = 0; i < digits.length; i++) {
reversed[i] = digits[digits.length - 1 - i];
}
return reversed;
}
// Method to compare two arrays and check if they are equal
public static boolean compareArrays(int[] array1, int[] array2) {
if (array1.length != array2.length) {
return false;
}
for (int i = 0; i < array1.length; i++) {
if (array1[i] != array2[i]) {
return false;
}
}
return true;
}
// Method to check if a number is a palindrome

public static boolean isPalindrome(int number) {
int[] digits = storeDigitsInArray(number);
int[] reversedDigits = reverseArray(digits);
return compareArrays(digits, reversedDigits);
}
// Method to check if a number is a duck number
public static boolean isDuckNumber(int number) {
String numStr = String.valueOf(number);
// Duck numbers must not start with 0 and must contain a '0' elsewhere
return numStr.contains("0") && !numStr.startsWith("0");
}
public static void main(String[] args) {
int number = 1221; // Example number
// Count digits
int digitCount = countDigits(number);
System.out.println("Count of digits: " + digitCount);
// Store digits in an array
int[] digits = storeDigitsInArray(number);
System.out.print("Digits: ");
for (int digit : digits) {
System.out.print(digit + " ");
}
System.out.println();
// Reverse the digits array
int[] reversedDigits = reverseArray(digits);
System.out.print("Reversed Digits: ");
for (int digit : reversedDigits) {
System.out.print(digit + " ");
}
System.out.println();
// Check if the number is a palindrome
boolean isPalindrome = isPalindrome(number);
System.out.println("Is Palindrome: " + isPalindrome);
// Check if the number is a duck number
boolean isDuck = isDuckNumber(number);
System.out.println("Is Duck Number: " + isDuck);
}
}
