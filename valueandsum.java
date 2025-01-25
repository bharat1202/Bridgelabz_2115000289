import java.util.Scanner;
public class valueandsum {
public static void main(String[] args) {
double[] values = new double[10];
double total = 0.0;
int index = 0;
Scanner scanner = new Scanner(System.in);
System.out.println("Enter up to 10 numbers (enter 0 or a negativenumber to stop):");
while (true) {
System.out.print("Enter number: ");
double input = scanner.nextDouble();
if (input <= 0 || index == 10) {
break;
}
values[index] = input;
index++;
}
System.out.println("You entered:");
for (int i = 0; i < index; i++) {
System.out.println(values[i]);total += values[i];
}
System.out.println("Total sum: " + total);
scanner.close();
}
}
