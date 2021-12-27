package system;

import java.util.ArrayList;

public class Consultant extends Doctor{
    ArrayList<Gerneral_Practitoner>gerneral_practitoners=new ArrayList<>();
    public Consultant(String name,String phone,String specialty) {
        this.name=name;
        this.phone=phone;
        this.specialty=specialty;
    }
    public void addItem(Gerneral_Practitoner gerneral_practitoner){
        this.gerneral_practitoners.add(gerneral_practitoner);
    }
    public ArrayList<Gerneral_Practitoner> getGerneral_practitoners() {
        return gerneral_practitoners;
    }
}

