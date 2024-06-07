package com.example.Practice.superc;

import org.springframework.stereotype.Component;

class One{
    public One(String name){
        System.out.print("One Constructor..."+name);
    }
}
class Two extends One{
    public Two(){
        super("Mahadev");
        System.out.print("Two Construtor");
    }
}

@Component
public class SuperKeywordConst{
public static  void main(String args[]){
     Two obj = new Two();
}
}

/*The super keyword in Java is used to explicitly call the superclass constructor or to access methods
and variables of the superclass that are hidden by the subclass. While the superclass constructor is called
automatically, the super keyword gives you control over which constructor of the superclass to call and allows
you to pass specific arguments to it.*/