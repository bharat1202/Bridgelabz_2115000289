import java.util.*;
class yards{
public static void main(String[]args){
Scanner sc= new Scanner(System.in);
System.out.println("enter the distance in feets");
double f= sc.nextInt();
double y= f/3;
double m= y/1760;
System.out.println("your distance in feet is " +f+ "in yards is "+y+ "and in miles is "+m);
}
}
