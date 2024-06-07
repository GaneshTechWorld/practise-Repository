package com.example.Practice.string;

import org.springframework.stereotype.Component;

@Component
public class StringContainVowels {
    public static int vowelsCounts(String str){
        int consonsnet =  (int)str.chars().filter(c -> "aeiouAEIOU".indexOf(c) != -1).count();
        int vowels = str.length() - consonsnet;
        System.out.print("consonenet :"+consonsnet+"and vowels :"+vowels);
        return 0;
    }
    public static boolean checkStringVowels(String str){
        return str.matches(".*[aeiouAEIOU].*");
    }
    public static void main(String args[]){
        System.out.println(checkStringVowels("mama"));
        System.out.println(vowelsCounts("Ganesh"));
    }
}
