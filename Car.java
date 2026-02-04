//no.2 guided exercise
class Car {
    String brand;
    String color;
    Car (String brand, String color) {
        this.brand = brand;
        this.color = color;
    }
    public static void main(String [] args) {
        Car myCar = new Car("Toyota", "Blue");
        System.out.println("Car Brand: " + myCar.brand);
        System.out.println(" Car Color: " + myCar.color);
    }
}
