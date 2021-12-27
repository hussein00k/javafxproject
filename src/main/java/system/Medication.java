package system;

public class Medication {
    String name;
    String day;
    String time;

    public Medication(String name, String day, String time) {
        this.name = name;
        this.day = day;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }
}
