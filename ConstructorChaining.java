
//machine problem no.4
class Student {
    String name;
    int age;
    String course;

    // Constructor 1
    Student() {
        this("Unknown", 0, "None"); // calls Constructor 3
    }

    // Constructor 2
    Student(String name) {
        this(name, 0, "None"); // calls Constructor 3
    }

    // Constructor 3
    Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    void display() {
        System.out.println(name + " | " + age + " | " + course);
    }
}

public class ConstructorChaining {
    public static void main(String[] args) {
        Student st1= new Student();
        Student st2= new Student("Anna");
        Student st3 = new Student("Mark", 21, "BSIT");
        st1.display();
        st2.display();
        st3.display();
    }
}
