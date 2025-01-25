import java.util.Scanner;
public class tablerange {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter a number to generate its multiplicationtable from 6 to 9: ");
if (scanner.hasNextInt()) {
int number = scanner.nextInt();
int[] multiplicationResult = new int[4];
for (int i = 0; i < 4; i++) {
multiplicationResult[i] = number * (6 + i);
}
for (int i = 0; i < 4; i++) {
System.out.println(number + " * " + (6 + i) + " = " +multiplicationResult[i]);
}
} else {
System.out.println("Invalid input. Please enter an integer.");
}
scanner.close();
}
}
