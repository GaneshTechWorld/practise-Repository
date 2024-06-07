package com.example.Practice.string;

import org.springframework.stereotype.Component;

@Component
public class StringPalindrom {
    public static  boolean checkPalimdrom(String str){
        String reverse = new StringBuilder(str).reverse().toString();
        System.out.print(str+"<-  ->"+reverse);
        return reverse.equals(str);  //== not used because it chekc memory location and equals check content
    }
    public static void main(String args[]){
        String str1 = "A man, a plan, a canal, Panama!";
        String str2 = "racecar";
        String str3 = "hello";
        String str4 = "aaaa";

        System.out.println(checkPalimdrom(str1)); // true
        System.out.println(checkPalimdrom(str2)); // true
        System.out.println(checkPalimdrom(str3)); // false
        System.out.println(checkPalimdrom(str4)); // false
    }
}
