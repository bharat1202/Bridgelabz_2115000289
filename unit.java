import java.util.*;
class unit{
public static void main(String[]args){
Scanner sc= new Scanner(System.in);
System.out.println("enter the unit price");
int u = sc.nextInt();
int q= sc.nextInt();
System.out.println("the total purchase price is INR " +(u*q)+" if the quantity is "+q+ "and unit price is INR "+u);
}
}
