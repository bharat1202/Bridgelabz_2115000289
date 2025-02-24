// Parent class
class Animal {
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

// Child class overriding makeSound() method
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

// Main class
public class OverrideAnimal {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.makeSound(); // Should print "Woof! Woof!"
    }
}
