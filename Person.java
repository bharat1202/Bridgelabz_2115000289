class Person {
String name;
int age;
public Person(String name, int age) {
this.name = name;
this.age = age;
}
}
class Teacher extends Person {
String subject;
public Teacher(String name, int age, String subject) {
super(name, age);
this.subject = subject;
}
public void displayRole() {
System.out.println("Teacher");
}
}
class Student extends Person {
int grade;
public Student(String name, int age, int grade) {
super(name, age);
this.grade = grade;
}
public void displayRole() {
System.out.println("Student");
}
}
class Staff extends Person {
String department;
public Staff(String name, int age, String department) {
super(name, age);
this.department = department;
}
public void displayRole() {
System.out.println("Staff");
}
}
class SchoolSystem {
public static void main(String[] args) {
Teacher t = new Teacher("Alice", 30, "Mathematics");
t.displayRole();
}
}