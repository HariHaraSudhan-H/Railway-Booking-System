import java.util.ArrayList;

public class booking {
    static ArrayList<passenger> lowerBerth = new ArrayList<passenger>();
    static ArrayList<passenger> middleBerth = new ArrayList<passenger>();
    static ArrayList<passenger> upperBerth = new ArrayList<passenger>();
    static ArrayList<passenger> RAC = new ArrayList<passenger>();
    static ArrayList<passenger> waitingList = new ArrayList<passenger>();

    public static void ticketBooking(passenger Passenger, String preference) {
        if ((preference.equals("L") && lowerBerth.size() < 1) || (preference.equals("M") && middleBerth.size() < 1)
                || (preference.equals("U") && upperBerth.size() < 1)) {
            if (preference.equals("L")) {
                lowerBerth.add(Passenger);
                System.out.println("Lower Berth alloted\nTicket Booked Successfully");
                Passenger.setSeatAlloted("L");
                return;
            }
            if (preference.equals("M")) {
                middleBerth.add(Passenger);
                System.out.println("Middle Berth alloted\nTicket Booked Successfully");
                Passenger.setSeatAlloted("M");
                return;
            }
            if (preference.equals("U")) {
                upperBerth.add(Passenger);
                System.out.println("Upper Berth alloted\nTicket Booked Successfully");
                Passenger.setSeatAlloted("U");
                return;
            }
        } else {
            if (lowerBerth.size() < 1) {
                lowerBerth.add(Passenger);
                System.out.println("Lower Berth alloted\nTicket Booked Successfully");
                Passenger.setSeatAlloted("L");
                return;
            }
            if (middleBerth.size() < 1) {
                middleBerth.add(Passenger);
                System.out.println("Middle Berth alloted\nTicket Booked Successfully");
                Passenger.setSeatAlloted("M");
                return;
            }
            if (upperBerth.size() < 1) {
                upperBerth.add(Passenger);
                System.out.println("Upper Berth alloted\nTicket Booked Successfully");
                Passenger.setSeatAlloted("U");
                return;
            }
        }
        if (RAC.size() < 1) {
            RAC.add(Passenger);
            System.out.println("Ticket booked under RAC");
            Passenger.setSeatAlloted("RAC");
            return;
        }
        if (waitingList.size() < 1) {
            waitingList.add(Passenger);
            System.out.println("Ticket booked under Waiting List");
            Passenger.setSeatAlloted("WL");
            return;
        }
        System.out.println("No Tickets available");
    }

    public static void cancelTicket(int passengerID) {
        if (cancelTicket(lowerBerth, passengerID,"L")) {
            return;
        }
        if (cancelTicket(middleBerth, passengerID,"M"))
            return;
        if (cancelTicket(upperBerth, passengerID,"U"))
            return;
        if (cancelTicket(RAC, passengerID,"RAC"))
            return;
        if (cancelTicket(waitingList, passengerID,"WL"))
            return;
        System.out.println("Passenger ID not found");
    }

    public static boolean cancelTicket(ArrayList<passenger> list, int passengerID,String berth) {
        for (passenger p : list) {
            if (p.getPassengerID() == passengerID) {
                System.out.println("Ticket for " + passengerID + " - " + p.getName() + "Is cancelled successfully");
                list.remove(p);
                if (list != RAC && list != waitingList) {
                    if (RAC.size() != 0) {
                        list.add(RAC.get(0));
                        RAC.get(0).setSeatAlloted(berth);
                        RAC.remove(0);
                    }
                }
                if (list != waitingList) {
                    if (waitingList.size() != 0) {
                        RAC.add(waitingList.get(0));
                        waitingList.get(0).setSeatAlloted("berth");
                        waitingList.remove(0);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void printAvailable() {
        System.out.println("LowerBerth ----> " + (21 - lowerBerth.size()) + "\nMiddle Berth ----> "
                + (21 - middleBerth.size()) + "\nUpper Berth ----> "
                + (21 - upperBerth.size()) + "\nRAC ----> " + (21 - RAC.size()) + "\nWaiting List ----> "
                + (21 - waitingList.size()));
    }

    public static void printBooked() {
        System.out.println("\nConfimed Tickets\n------------------------\n");
        for (passenger p : lowerBerth) {
            System.out.println("Passenger ID - " + p.getPassengerID()
                    + "\nName - " + p.getName()
                    + "\nAge _ " + p.getAge()
                    + "\nSeat Alloted - " + p.getSeatAlloted() + "\n");
        }
        for (passenger p : middleBerth) {
            System.out.println("Passenger ID - " + p.getPassengerID()
                    + "\nName - " + p.getName()
                    + "\nAge _ " + p.getAge()
                    + "\nBerth Perference - " + p.getSeatAlloted() + "\n");
        }
        for (passenger p : upperBerth) {
            System.out.println("Passenger ID - " + p.getPassengerID()
                    + "\nName - " + p.getName()
                    + "\nAge _ " + p.getAge()
                    + "\nSeat Alloted - " + p.getSeatAlloted() + "\n");
        }
        System.out.println("\nRAC Tickets\n------------------------\n");
        for (passenger p : RAC) {
            System.out.println("Passenger ID - " + p.getPassengerID()
                    + "\nName - " + p.getName()
                    + "\nAge _ " + p.getAge()
                    + "\nCurrent Status - " + p.getSeatAlloted() + "\n");
        }
        System.out.println("\nWaiting List Tickets\n------------------------\n");
        for (passenger p : waitingList) {
            System.out.println("Passenger ID - " + p.getPassengerID()
                    + "\nName - " + p.getName()
                    + "\nAge _ " + p.getAge()
                    + "\nCurrent Status - " + p.getSeatAlloted() + "\n");
        }
    }
}