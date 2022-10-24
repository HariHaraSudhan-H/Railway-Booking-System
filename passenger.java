public class passenger {
    static int i=1;
    private String Name;
    private int Age;
    private String berthPreference;
    private int passengerID;
    private String seatAlloted;

    public passenger(String name, int age, String berthPreference) {
        Name = name;
        Age = age;
        this.berthPreference = berthPreference;
        this.passengerID = i;
        i++;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public String getBerthPreference() {
        return berthPreference;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setSeatAlloted(String seatAlloted) {
        this.seatAlloted = seatAlloted;
    }

    public String getSeatAlloted() {
        return seatAlloted;
    }

}
