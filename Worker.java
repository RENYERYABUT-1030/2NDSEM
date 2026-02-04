
// guided exercise no.6
class Employee {
    String name;

    Employee(String name) {
        this.name = name;
        System.out.println(" Employee Constructor: " + name);
    }
}
class Manager extends Employee {
    double bonus;
    Manager(String name, double bonus) {
        super(name);
        this.bonus = bonus;
    }
    void display() {
        System.out.println("Name: " + name);
        System.out.println(" Bonus: " + bonus);

    }
}
public class Worker {
    public static void main(String [] args) {

        Manager manager = new Manager ("Richard", 1000.0);
        manager.display();
    }
}