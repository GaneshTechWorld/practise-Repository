package com.example.Practice.exception;

import org.springframework.stereotype.Component;
class MyException extends Exception{
    public MyException(String message){
        super(message);
    }
}
class Calculator{
    int addTwoInt(int a,int b) throws MyException {
            if (b !=0)
                return a+b;
            else
                throw new MyException("We Can't Devide give number with 0");
    }
}
@Component
public class CustomException {
    public static void main(String args[]) throws MyException {
        Calculator addObj = new Calculator();
        try{
            int num = addObj.addTwoInt(10, 0);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
/*A stack trace is information about an exception that occurs.
 It shows where the error happened, including the class, method, and line number.
 It helps you understand what went wrong in your program.*/