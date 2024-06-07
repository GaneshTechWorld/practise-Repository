package com.example.Practice.string;

import org.springframework.stereotype.Component;

@Component
public class CharNumOccurence {

    public static int giveCount(String str,char ch){
        return (int) str.chars().filter(c -> c == ch).count();
    }
    public static void main(String args[]){
        String str = "hello world";
        char ch = 'l';

        long occurrences = giveCount(str, ch);
        System.out.println("Number of occurrences of '" + ch + "' in the string: " + occurrences);
    }
}
