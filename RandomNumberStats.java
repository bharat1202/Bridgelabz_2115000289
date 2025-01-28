public class RandomNumberStats {
// Method to generate an array of 4-digit random numbers
public static int[] generate4DigitRandomArray(int size) {
int[] randomNumbers = new int[size];
for (int i = 0; i < size; i++) {
// Generate random 4-digit number between 1000 and 9999
randomNumbers[i] = (int)(Math.random() * 9000) + 1000;
}
return randomNumbers;
}
// Method to find the average, min and max value of an array
public static double[] findAverageMinMax(int[] numbers) {
double sum = 0;
int min = numbers[0];
int max = numbers[0];
// Loop through the array to calculate sum, min, and max
for (int num : numbers) {
sum += num;
min = Math.min(min, num);
max = Math.max(max, num);
}

// Calculate average
double average = sum / numbers.length;
// Return an array with average, min, and max
return new double[] {average, min, max};
}
public static void main(String[] args) {
// Generate an array of 5 random 4-digit numbers
int[] randomNumbers = generate4DigitRandomArray(5);
// Find the average, min, and max of the array
double[] results = findAverageMinMax(randomNumbers);
// Display the results
System.out.println("Generated Random 4-digit Numbers:");
for (int num : randomNumbers) {
System.out.println(num);
}
System.out.println("\nAverage: " + results[0]);
System.out.println("Minimum: " + results[1]);
System.out.println("Maximum: " + results[2]);
}
}
