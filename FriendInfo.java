import java.util.Scanner;
public class FriendInfo {
// Method to find the youngest friend
public static String findYoungest(int[] ages) {
int youngestAge = ages[0];
String youngestFriend = "Amar";
if (ages[1] < youngestAge) {
youngestAge = ages[1];
youngestFriend = "Akbar";
}
if (ages[2] < youngestAge) {
youngestAge = ages[2];
youngestFriend = "Anthony";
}
return youngestFriend;
}
// Method to find the tallest friend
public static String findTallest(double[] heights) {
double tallestHeight = heights[0];
String tallestFriend = "Amar";
if (heights[1] > tallestHeight) {
tallestHeight = heights[1];
tallestFriend = "Akbar";
}
if (heights[2] > tallestHeight) {
tallestHeight = heights[2];

tallestFriend = "Anthony";
}
return tallestFriend;
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Arrays to store ages and heights of the three friends
int[] ages = new int[3];
double[] heights = new double[3];
// Take input for the age and height of the three friends
System.out.print("Enter age of Amar: ");
ages[0] = scanner.nextInt();
System.out.print("Enter height of Amar (in meters): ");
heights[0] = scanner.nextDouble();
System.out.print("Enter age of Akbar: ");
ages[1] = scanner.nextInt();
System.out.print("Enter height of Akbar (in meters): ");
heights[1] = scanner.nextDouble();
System.out.print("Enter age of Anthony: ");
ages[2] = scanner.nextInt();
System.out.print("Enter height of Anthony (in meters): ");
heights[2] = scanner.nextDouble();
// Find and display the youngest friend
String youngest = findYoungest(ages);
System.out.println("The youngest friend is: " + youngest);
// Find and display the tallest friend
String tallest = findTallest(heights);
System.out.println("The tallest friend is: " + tallest);
}
}
