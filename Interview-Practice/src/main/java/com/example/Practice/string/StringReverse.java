package com.example.Practice.string;

import org.springframework.stereotype.Component;


public class StringReverse {
    public static String stringReverse(String reverse){
        return new StringBuilder(reverse).reverse().toString();
    }
    public static void main(String args []) {
        String originalString = "Hello, World!";
        String reversedString = stringReverse(originalString);
        System.out.println("Original string: " + originalString);
        System.out.println("Reversed string: " + reversedString);
    }
}
