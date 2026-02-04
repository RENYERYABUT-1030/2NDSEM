// no.5 guided chap 1
class Shape {
    String type;

    Shape(String type) {
        this.type = type;
        System.out.println("Shape Constructor: " + type);
    }
}

class Circle extends Shape {
    double radius;

    Circle(String type, double radius) {
        super(type);
        this.radius = radius;
    }

    void display() {
        System.out.println("Type: " + type);
        System.out.println("Radius: " + radius);
    }
}

public class Mainshape{

    public static void main(String[] args) {
        Circle circle = new Circle("Circle", 5.0);
        circle.display();
    }
}