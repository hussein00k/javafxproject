package system;

public class Hospital_doctor extends Doctor{
    int number;

    public Hospital_doctor(String name,String phone,String specialty,int number) {
        this.name = name;
        this.phone=phone;
        this.specialty=specialty;
        this.number=number;
    }

    public int getNumber() {
        return number;
    }
}
