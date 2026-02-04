// Guided no.4 chap 1

public class Persons{
    String name;
    int age;

    Persons() {
        this("Unknown", 0);
    }

    Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Persons person1 = new Persons();
        person1.display();

        Persons person2 = new Persons("Richard", 25);
        person2.display();
    }
}