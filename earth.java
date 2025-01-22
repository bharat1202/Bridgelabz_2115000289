class earth{
public static void main(String[]args){
double r= 6378;
double kmv= 1.3 * 3.14 * r*r*r;
double mmv= kmv*1.6;
System.out.println("The volume of earth in km is " +kmv+ "and the volume in miles is "+mmv);
}
}
