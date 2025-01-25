import java.util.Scanner;
public class digit {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter a number: ");
int number = scanner.nextInt();
int[] frequency = new int[10];
int tempNumber = Math.abs(number);
while (tempNumber > 0) {
int digit = tempNumber % 10;
frequency[digit]++;
tempNumber /= 10;
}
System.out.println("Digit\tFrequency");
for (int i = 0; i < 10; i++) {
if (frequency[i] > 0) {
System.out.println(i + "\t" + frequency[i]);
}
}
scanner.close();
}
}
