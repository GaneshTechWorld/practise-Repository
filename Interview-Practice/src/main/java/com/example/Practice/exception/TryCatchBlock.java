package com.example.Practice.exception;

public class TryCatchBlock {
    public static void main(String args[]) throws MyException {
        try {
          int a  = 10/0;
            throw new MyException("Cant Throw Exception 1..");
        } catch (Exception e) {
            throw new MyException("Cant Throw Exception 2..");
        }finally {
            System.out.println("Hello This Is Finally Block &");
        }
    }
}
