import java.util.*;
class height{
public static void main(String[]args){
Scanner sc = new Scanner(System.in);
System.out.println("height in cm");
double h = sc.nextDouble();
double i = h/2.54;
double f= i/12;
System.out.println("Your height in cm is "+h+ " in inches is "+i+ " and in feet is " +f);
}
}
