import java.util.Scanner;
public class numanalysis {
public static void main(String[] args) {
int[] numbers = new int[5];
Scanner scanner = new Scanner(System.in);
System.out.println("Enter 5 numbers:");
for (int i = 0; i < numbers.length; i++) {
System.out.print("Enter number " + (i + 1) + ": ");
numbers[i] = scanner.nextInt();
}
for (int number : numbers) {
if (number > 0) {
if (number % 2 == 0) {
System.out.println("The number " + number + " ispositive and even.");
} else {
System.out.println("The number " + number + " ispositive and odd.");
}
} else if (number < 0) {
System.out.println("The number " + number + " isnegative.");
} else {
System.out.println("The number is zero.");
}
}
if (numbers[0] > numbers[4]) {
System.out.println("The first element is greater than the lastelement.");
} else if (numbers[0] < numbers[4]) {
System.out.println("The first element is less than the lastelement.");
} else {
System.out.println("The first element is equal to the lastelement.");
}
scanner.close();
}
}
