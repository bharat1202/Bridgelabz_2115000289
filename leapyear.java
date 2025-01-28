import java.util.Scanner;
public class leapyear {
// Method to check if the year is a leap year
public static boolean isLeapYear(int year) {

// Check if the year is divisible by 4, and either not divisible by 100, ordivisible by 400
if (year >= 1582 && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)))
{
return true;
} else {
return false;
}
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Get input for the year
System.out.print("Enter a year: ");
int year = scanner.nextInt();
// Check if the year is a leap year and output the result
if (isLeapYear(year)) {
System.out.println(year + " is a Leap Year.");
} else {
System.out.println(year + " is not a Leap Year.");
}
}
}
