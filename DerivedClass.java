// Base class
class House {
    protected String address;
    protected int yearBuilt;

    public House(String address, int yearBuilt) {
        this.address = address;
        this.yearBuilt = yearBuilt;
    }

    public void showInfo() {
        System.out.println("Address: " + address);
        System.out.println("Year Built: " + yearBuilt);
    }
}

// Derived class
class Villa extends House {
    private int floors;
    private double price;

    public Villa(String address, int yearBuilt, int floors, double price) {
        super(address, yearBuilt); // call parent constructor
        this.floors = floors;
        this.price = price;
    }

    @Override
    public void showInfo() {
        super.showInfo(); // reuse House method
        System.out.println("Floors: " + floors);
        System.out.println("Price: $" + price);
    }
}

// Main class
public class DerivedClass {
    public static void main(String[] args) {
        Villa myVilla = new Villa("456 Luxury Lane", 2020, 2, 450000.0);
        myVilla.showInfo();
    }
}
