public class NumberChecker2 {
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
// Method to check if a number is a duck number
public static boolean isDuckNumber(int number) {
String numStr = String.valueOf(number);
return numStr.contains("0");
}
// Method to check if a number is an Armstrong number
public static boolean isArmstrongNumber(int number) {
int[] digits = storeDigitsInArray(number);
int sum = 0;
int power = digits.length;
for (int digit : digits) {
sum += Math.pow(digit, power);
}
return sum == number;
}
// Method to find the largest and second largest elements in the digits array5
public static int[] findLargestAndSecondLargest(int[] digits) {
int largest = Integer.MIN_VALUE;
int secondLargest = Integer.MIN_VALUE;
for (int digit : digits) {
if (digit > largest) {
secondLargest = largest;
largest = digit;
} else if (digit > secondLargest && digit != largest) {
secondLargest = digit;
}
}
return new int[]{largest, secondLargest};
}
// Method to find the smallest and second smallest elements in the digits array
public static int[] findSmallestAndSecondSmallest(int[] digits) {
int smallest = Integer.MAX_VALUE;
int secondSmallest = Integer.MAX_VALUE;
for (int digit : digits) {
if (digit < smallest) {
secondSmallest = smallest;
smallest = digit;
} else if (digit < secondSmallest && digit != smallest) {
secondSmallest = digit;
}
}
return new int[]{smallest, secondSmallest};
}
public static void main(String[] args) {
int number = 153; // Example number
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
// Check if it's a duck number

boolean isDuck = isDuckNumber(number);
System.out.println("Is Duck Number: " + isDuck);
// Check if it's an Armstrong number
boolean isArmstrong = isArmstrongNumber(number);
System.out.println("Is Armstrong Number: " + isArmstrong);
}}

