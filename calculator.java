import java.util.*;
class calculator{
public static void main(String[]args){
Scanner sc = new Scanner(System.in);
System.out.println("enter first number");
int f= sc.nextInt();
System.out.println("enter second number");
int s= sc.nextInt();
int add= f+s;
int sub= f-s;
int mult= f*s;
int div =f/s;
System.out.println("the addition , subtraction , multiplication and division of 2 numbers are "+add+" "+sub+ " "+mult+ " "+div);
}
}
