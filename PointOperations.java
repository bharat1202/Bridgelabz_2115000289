public class PointOperations {
// Method to calculate the Euclidean distance between two points
public static double calculateDistance(double x1, double y1, double x2, double y2) {
return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
}
// Method to find the equation of the line given two points
public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
double slope = (y2 - y1) / (x2 - x1); // Calculate slope (m)
double yIntercept = y1 - (slope * x1); // Calculate y-intercept (b)
return new double[]{slope, yIntercept}; // Return as an array [slope,yIntercept]
}
public static void main(String[] args) {

java.util.Scanner scanner = new java.util.Scanner(System.in);
// Input coordinates of the two points
System.out.print("Enter x1: ");
double x1 = scanner.nextDouble();
System.out.print("Enter y1: ");
double y1 = scanner.nextDouble();
System.out.print("Enter x2: ");
double x2 = scanner.nextDouble();
System.out.print("Enter y2: ");
double y2 = scanner.nextDouble();
// Calculate the Euclidean distance
double distance = calculateDistance(x1, y1, x2, y2);
System.out.printf("The Euclidean distance between the points is: %.2f\n",distance);
// Find the equation of the line
if (x1 != x2) { // Ensure the points are not vertical to avoid division byzero
double[] lineEquation = findLineEquation(x1, y1, x2, y2);
System.out.printf("The equation of the line is: y = %.2f*x + %.2f\n",lineEquation[0], lineEquation[1]);
} else {
System.out.println("The line is vertical, equation is: x = " + x1);
}
}
}
