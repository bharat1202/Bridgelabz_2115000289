import java.util.Arrays;
public class FootballTeamHeights {
// Method to generate random heights for players in the range 150 to 250 cms
public static int[] generateHeights(int size) {
int[] heights = new int[size];
for (int i = 0; i < size; i++) {
heights[i] = (int) (Math.random() * 101) + 150; // Random value between150 and 250
}
return heights;
}
// Method to find the sum of all elements in the array
public static int findSum(int[] heights) {
int sum = 0;
for (int height : heights) {
sum += height;
}
return sum;
}
// Method to calculate the mean height
public static double findMean(int[] heights) {
int sum = findSum(heights);
return (double) sum / heights.length;
}

// Method to find the shortest height
public static int findShortest(int[] heights) {
int shortest = heights[0];
for (int height : heights) {
if (height < shortest) {
shortest = height;
}
}
return shortest;
}
// Method to find the tallest height
public static int findTallest(int[] heights) {
int tallest = heights[0];
for (int height : heights) {
if (height > tallest) {
tallest = height;
}
}
return tallest;
}
public static void main(String[] args) {
// Generate heights for 11 players
int[] heights = generateHeights(11);
// Calculate shortest, tallest, and mean heights
int shortest = findShortest(heights);
int tallest = findTallest(heights);
double mean = findMean(heights);
// Display results
System.out.println("Player Heights: " + Arrays.toString(heights));
System.out.println("Shortest Height: " + shortest + " cm");
System.out.println("Tallest Height: " + tallest + " cm");
System.out.println("Mean Height: " + String.format("%.2f", mean) + " cm");
}
}
