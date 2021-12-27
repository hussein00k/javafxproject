package system;

import java.util.ArrayList;

public class Patient {
    public String name;
    public int age;
    public String address;
    public String phone;
    ArrayList<Condtion>condtions=new ArrayList<>();

    public Patient(String name, int age, String address, String phone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Condtion> getCondtions() {
        return condtions;
    }
}
