package com.example.Practice.interfce;

interface  Animal{
    int a =10;
       void walk();
       void eat();
}
interface  Human {
    public  void walk();
    default void eat(){
        System.out.print("Default method of Human...");
    }
}
class Dog implements  Animal,Human{

    @Override
    public void walk() {
        System.out.println("Dog Walking");
    }
    @Override
    public void eat() {
        System.out.println("Dog Eating");
    }
}
public class DemoInterface {
    public static void main(String args[]){
        Dog d = new Dog();
        d.eat();
        d.walk();
        System.out.print(d.a);
    }
}
