import java.util.Scanner;
public class copy {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter number of rows: ");
int rows = scanner.nextInt();

System.out.print("Enter number of columns: ");
int columns = scanner.nextInt();
int[][] matrix = new int[rows][columns];
System.out.println("Enter elements of the matrix:");
for (int i = 0; i < rows; i++) {
for (int j = 0; j < columns; j++) {
matrix[i][j] = scanner.nextInt();
}
}
int[] oneDArray = new int[rows * columns];
int index = 0;
for (int i = 0; i < rows; i++) {
for (int j = 0; j < columns; j++) {
oneDArray[index++] = matrix[i][j];
}
}
System.out.print("1D Array: ");
for (int i = 0; i < oneDArray.length; i++) {
System.out.print(oneDArray[i] + " ");
}
scanner.close();
}
}
