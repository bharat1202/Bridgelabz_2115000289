class Employee {
private String name;
private int empId;
private double salary;

public Employee(String name, int empId, double salary) {
this.name = name;
this.empId = empId;
this.salary = salary;
 }

public void displayDetails() {
System.out.println("Employee ID: " + empId);
System.out.println("Name: " + name);
System.out.println("Salary: $" + salary);
}

public static void main(String[] args) {
Employee emp1 = new Employee("John Doe", 101, 50000);
Employee emp2 = new Employee("Jane Smith", 102, 60000);

System.out.println("Employee Details:");
 emp1.displayDetails();
System.out.println();
 emp2.displayDetails();
 }
}
