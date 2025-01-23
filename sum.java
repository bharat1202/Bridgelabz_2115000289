import java.util.*;
class sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int num = -1;

        while (num != 0) { 
            num = sc.nextInt(); 
            sum = sum + num;
        }
        
        System.out.println("Total sum is " + sum);
    }
}

