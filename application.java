import java.util.Scanner;

public class application {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter choice 1. Book Ticket 2. Cancel Ticket 3.Print List");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    bookticket();
                    booking.printAvailable();
                    break;
                case 2:
                    cancelTicket();
                    booking.printAvailable();
                    break;
                case 3:
                    printList();
                    break;
            }
        }
    }

    public static void bookticket() {
        scan.nextLine();
        System.out.println("Passenger Name");
        String name = scan.nextLine();
        System.out.println("Age");
        int age = scan.nextInt();
        scan.nextLine();
        System.out.println("Berth Perference - L / M / U");
        String berthPreference = scan.nextLine();
        booking.ticketBooking(new passenger(name, age, berthPreference), berthPreference);
    }

    public static void cancelTicket() {
        System.out.println("Enter Passenger ID ");
        int ID = scan.nextInt();
        booking.cancelTicket(ID);
    }

    public static void printList() {
        booking.printBooked();
    }
}
