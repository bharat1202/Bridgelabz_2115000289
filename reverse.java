import java.util.Scanner;
public class reverse {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter a number: ");
int number = scanner.nextInt();
int digitCount = 0;
int tempNumber = number;
while (tempNumber != 0) {
digitCount++;
tempNumber /= 10;
}
int[] digits = new int[digitCount];
for (int i = 0; i < digitCount; i++) {
digits[i] = number % 10;
number /= 10;
}
System.out.print("The reversed number is: ");
for (int i = 0; i < digitCount; i++) {
System.out.print(digits[i]);
}
scanner.close();
}
}
