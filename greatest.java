import java.util.*;
class greatest{
public static void main(String[]args){
Scanner sc= new Scanner(System.in);
int num1 = sc.nextInt();
int num2 = sc.nextInt();
int num3 = sc.nextInt();
if(num1>num2 && num1>num3){
System.out.println("greatest");
}
else{
System.out.println("not greatest");
}
}
}
