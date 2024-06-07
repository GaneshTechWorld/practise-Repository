package com.example.Practice.superc;

class Animal{
    public int age = 10;
    public void eat(){
        System.out.println("Animal Eat Method...");
    }
}
class Dog extends  Animal{
   public void dogInfo(){
       super.age = 30;
       super.eat();
       System.out.println("Animal Eat Method...");
   }
}
public class SuperClassMethdVerb {
    public static void main(String args[]){
            Dog obj = new Dog();
            obj.dogInfo();
            System.out.print(obj.age);
    }
}
