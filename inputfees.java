import java.util.*;
class inputfees{
public static void main(String[]args){
Scanner sc = new Scanner(System.in);
System.out.println("enter the amount of fees");
int fee = sc.nextInt();
System.out.println("enter discount");
int d = sc.nextInt();
int discount = (fee/d);
System.out.println("the discount is " +discount+ "and discounted fees is  " +(fee-discount));
}
}
