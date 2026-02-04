import java.util.*;
import java.io.*;

public class hotel {

    static final int MAX_ROOMS = 10;

    static boolean[] rooms = new boolean[MAX_ROOMS];
    static String[] guestNames = new String[MAX_ROOMS];
    static String[] checkInTimes = new String[MAX_ROOMS];
    static String[] checkOutTimes = new String[MAX_ROOMS];
    static String[] roomTypes = new String[MAX_ROOMS];
    static double[] roomPrices = new double[MAX_ROOMS];

    static List<String> history = new ArrayList<>();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        loadData();
        boolean isAdmin = false;

        System.out.print("Enter admin password (or press Enter for guest): ");
        String password = input.nextLine();
        if (password.equals("admin123")) { isAdmin = true; System.out.println("Admin access granted."); }

        int choice;
        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Search Guest");
            if (isAdmin) {
                System.out.println("5. List Booked Guests");
                System.out.println("6. Sort Guests Alphabetically");
                System.out.println("7. View Booking History");
                System.out.println("8. Save Data");
                System.out.println("9. Exit");
            } else {
                System.out.println("5. Exit");
            }

            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine(); // consume newline

            if (isAdmin) {
                switch (choice) {
                    case 1: viewRoomsAdmin(); break;
                    case 2: bookRoom(); break;
                    case 3: cancelReservation(); break;
                    case 4: searchGuest(); break;
                    case 5: listBookedGuests(); break;
                    case 6: sortGuestsAlphabetically(); break;
                    case 7: viewHistory(); break;
                    case 8: saveData(); break;
                    case 9: System.out.println("Exiting..."); break;
                    default: System.out.println("Invalid option.");
                }
            } else {
                switch (choice) {
                    case 1: viewRoomsGuest(); break;
                    case 2: bookRoom(); break;
                    case 3: cancelReservation(); break;
                    case 4: searchGuest(); break;
                    case 5: System.out.println("Exiting..."); choice = 5; break;
                    default: System.out.println("Invalid option.");
                }
            }

        } while ((isAdmin && choice != 9) || (!isAdmin && choice != 5));
    }

    public static void viewRoomsAdmin() {
        System.out.println("\nROOM STATUS (Admin View):");
        for (int i = 0; i < MAX_ROOMS; i++) {
            if (rooms[i]) {
                System.out.println("Room " + (i+1) + " | " + roomTypes[i] + " | " + roomPrices[i] + " | Booked by "
                        + guestNames[i] + " | In: " + checkInTimes[i] + " | Out: " + checkOutTimes[i]);
            } else {
                System.out.println("Room " + (i+1) + " | Available");
            }
        }
    }

    public static void viewRoomsGuest() {
        System.out.println("\nROOM STATUS (Guest View):");
        for (int i = 0; i < MAX_ROOMS; i++) {
            if (rooms[i]) {
                System.out.println("Room " + (i+1) + " | " + roomTypes[i] + " | Booked");
            } else {
                System.out.println("Room " + (i+1) + " | Available");
            }
        }
    }

    public static void bookRoom() {
        System.out.print("Enter room number (1-10): ");
        int room = input.nextInt() - 1;

        if (room < 0 || room >= MAX_ROOMS) { System.out.println("Invalid room."); return; }
        if (rooms[room]) { System.out.println("Room already booked."); return; }

        input.nextLine();
        System.out.print("Enter guest name: ");
        String name = input.nextLine();

        System.out.print("Enter check-in time: ");
        String checkIn = input.nextLine();

        System.out.print("Enter check-out time: ");
        String checkOut = input.nextLine();

        System.out.println("Select room type: 1=Single 2=Double 3=Suite");
        int typeChoice = input.nextInt();

        String type;
        double price;
        if (typeChoice == 1) { type = "Single"; price = 1000; }
        else if (typeChoice == 2) { type = "Double"; price = 2000; }
        else { type = "Suite"; price = 3500; }

        rooms[room] = true;
        guestNames[room] = name;
        checkInTimes[room] = checkIn;
        checkOutTimes[room] = checkOut;
        roomTypes[room] = type;
        roomPrices[room] = price;

        history.add("BOOKED: " + name + " | Room " + (room+1) + " | " + type);
        System.out.println("Room booked successfully!");
    }

    // Example stub methods for remaining functionality
    public static void cancelReservation() {
        System.out.println("Cancel reservation functionality here");
    }
    public static void searchGuest() {
        System.out.println("Search guest functionality here");
    }
    public static void listBookedGuests() {
        System.out.println("List booked guests functionality here");
    }
    public static void sortGuestsAlphabetically() {
        System.out.println("Sort guests functionality here");
    }
    public static void viewHistory() {
        System.out.println("View history functionality here");
    }
    public static void saveData() {
        System.out.println("Save data functionality here");
    }
    public static void loadData() {
        System.out.println("Load data functionality here");
    }
}
