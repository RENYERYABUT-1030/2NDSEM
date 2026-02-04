// Machine Problem no.3

class Person1 {
    protected String name;
    protected int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("\nHi, I'm " + name + " and I'm " + age + " years old.");
    }
}

// Derived class Employee1 extends Person1
class Employee1 extends Person1 {
    private String name;   // field hiding (allowed)
    private String jobTitle;

    public Employee1(String name, int age, String jobTitle) {
        super(name, age);
        this.name = "Employee " + name;
        this.jobTitle = jobTitle;
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("I also work as a " + jobTitle + ".");
        System.out.println();

        System.out.println("Employee class name field: " + this.name);

        System.out.println();
        System.out.println("Person class name field: " + super.name);
    }
}

// Demo class
public class ConstructorMethod {
    public static void main(String[] args) {
        Employee1 e1 = new Employee1("Ryzen", 30, "DPWH CONTRATCOR");
        e1.introduce();
    }
}
