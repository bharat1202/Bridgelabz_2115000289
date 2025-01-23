import java.util.Scanner;

public classv whilesum{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

               System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

               if (n <= 0) {
            System.out.println("Please enter a positive natural number.");
        } else {
                   int formulaSum = n * (n + 1) / 2;

                   int loopSum = 0;
            int i = 1;
            while (i <= n) {
                loopSum += i;
                i++;
            }

                       System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using while loop: " + loopSum);

           
            if (formulaSum == loopSum) {
                System.out.println("The results from both computations are correct!");
            } else {
                System.out.println("There is a discrepancy between the two computations.");
																			            }
 }
       
    }
}
