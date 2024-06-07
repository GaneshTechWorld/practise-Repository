package com.example.Practice.exception;

public class UnCheckedException {
    public static void main(String args[]){
        //NumberFormateException
        String age = "";
        int ageN = Integer.parseInt(age);
        //ArrayIndexOutOfBoundsException
        int arr[] = {1,2,3,4,5};
        System.out.println(arr[5]);
        String str = null;
        System.out.println(str.length());
        //ArithmeticException
        int a = 10/0;
    }
}
