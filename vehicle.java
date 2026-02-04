// guided execrcise no.1
class vehicle {
    private String brand;
    private String color;

    
    public static void main(String[] args) {
        vehicle myCar = new vehicle();
        myCar.brand = "Toyota";
        myCar.color = "Red";
        System.out.println("Car Brand: " + myCar.brand);
        System.out.println("Car Color: " + myCar.color);
    }
}