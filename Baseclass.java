
// Machine Problem no.1
// Base class Person
class Person {
    // Common attributes
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Common method
    public void introduce() {
        System.out.println("Hi, my name is " + name + " and I am " + age + " years old.");
    }
}

// Demo class with main method
public class Baseclass {
    public static void main(String[] args) {
        // Create a Person object
        Person person1 = new Person("Alice", 17     );

        // Use methods
        System.out.println("Name: " + person1.getName());
        System.out.println("Age: " + person1.getAge());
        person1.introduce();
    }
}