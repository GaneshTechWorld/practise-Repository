package com.example.Practice.abstrac;


abstract class TwoWheeler{
    TwoWheeler(){
        System.out.println("Two Wheeler Constructor");
    }
    public  abstract void fuelType();
    public  void gearNumbers(){
        System.out.println("Numbers Of gears are 5.this is TwoWheeler mthd");
    }
}
class Pulsoor extends TwoWheeler {
    Pulsoor(){
        System.out.println("Pulsoor class constructor...");
    }
    public void fuelType(){
        System.out.println("Fuel Type Is petrol");
    }
    public  void gearNumbers(){
        System.out.println("Numbers Of gears are 4.this is Pulsoor mthd");
    }
}

public class abstrction {
    public static void main(String args[]){
       /* System.out.println("...Rahul Mahajan...");
        Pulsoor obj = new Pulsoor();
        obj.fuelType();
        obj.gearNumbers();*/
        TwoWheeler t = new Pulsoor();
        t.gearNumbers();
    }
}
