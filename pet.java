
//guided no.3
class Animal {
    void sound() {
        System.out.println("Animals make sounds.");
    }
}

class Dog extends Animal {
    void sound() {
        super.sound();
        System.out.println("Dogs bark.");
    }
}

public class pet {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();
    }
}