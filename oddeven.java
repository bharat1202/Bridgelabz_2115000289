import java.util.Scanner;
public class oddeven {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
int inputNumber = scanner.nextInt();
if (inputNumber <= 0) {
System.out.println("Error: Not a natural number. Exiting.");
scanner.close();
return;
}
int[] evenNumbers = new int[inputNumber / 2 + 1];
int[] oddNumbers = new int[inputNumber / 2 + 1];
int evenIndex = 0, oddIndex = 0;
for (int i = 1; i <= inputNumber; i++) {

if (i % 2 == 0) {
evenNumbers[evenIndex++] = i;
} else {
oddNumbers[oddIndex++] = i;
}
}
System.out.print("Even numbers: ");
for (int i = 0; i < evenIndex; i++) {
System.out.print(evenNumbers[i] + " ");
}
System.out.println();
System.out.print("Odd numbers: ");
for (int i = 0; i < oddIndex; i++) {
System.out.print(oddNumbers[i] + " ");
}
scanner.close();
}
}
