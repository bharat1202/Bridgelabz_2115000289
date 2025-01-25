import java.util.Scanner;
public class bmi {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the number of persons: ");
int numPersons = scanner.nextInt();
double[] weights = new double[numPersons];
double[] heights = new double[numPersons];
double[] bmis = new double[numPersons];
String[] statuses = new String[numPersons];
for (int i = 0; i < numPersons; i++) {
System.out.print("Enter weight (kg) of person " + (i + 1) + ":");
weights[i] = scanner.nextDouble();
System.out.print("Enter height (m) of person " + (i + 1) + ":");
heights[i] = scanner.nextDouble();
}
for (int i = 0; i < numPersons; i++) {
bmis[i] = weights[i] / (heights[i] * heights[i]);
if (bmis[i] <= 18.4) {
statuses[i] = "Underweight";
} else if (bmis[i] <= 24.9) {
statuses[i] = "Normal";
} else if (bmis[i] <= 39.9) {
statuses[i] = "Overweight";
} else {
statuses[i] = "Obese";
}
}
System.out.println("Height (m)\tWeight (kg)\tBMI\tStatus");
for (int i = 0; i < numPersons; i++) {
System.out.printf("%.2f\t\t%.2f\t\t%.2f\t%s%n", heights[i],weights[i], bmis[i], statuses[i]);
}
scanner.close();
}
}
