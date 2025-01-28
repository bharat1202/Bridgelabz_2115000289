public class QuadraticEquationSolver {
// Method to find the roots of a quadratic equation
public static double[] findRoots(double a, double b, double c) {
// Calculate delta (discriminant)
double delta = b * b - 4 * a * c;
// Case 1: If delta is negative, return an empty array (no real roots)
if (delta < 0) {
return new double[0]; // Empty array for no real roots
}
// Case 2: If delta is zero, there's one real root
if (delta == 0) {
double root = -b / (2 * a);
return new double[]{root}; // Return one root
}
// Case 3: If delta is positive, two real roots exist
double root1 = (-b + Math.sqrt(delta)) / (2 * a);
double root2 = (-b - Math.sqrt(delta)) / (2 * a);
return new double[]{root1, root2}; // Return two roots
}
public static void main(String[] args) {
// Coefficients of the quadratic equation
double a = 1;
double b = -3;
double c = 2;
// Find the roots
double[] roots = findRoots(a, b, c);
// Display the roots
if (roots.length == 0) {
System.out.println("No real roots.");
} else if (roots.length == 1) {
System.out.println("The root is: " + roots[0]);
} else {
System.out.println("The roots are: " + roots[0] + " and " + roots[1]);
}
}
}
