package com.example.Practice.string;

import org.springframework.stereotype.Component;

import java.util.Arrays;

public class Anagram
{
    public static boolean checkAnagram(String one,String two) {

        String firstString = one.replaceAll("\\s","").toLowerCase();
        String secondString = two.replaceAll("\\s","").toLowerCase();
        if(one.equals("") || two.equals(""))
            return false;
        if(one.length() != two.length())
            return false;
        char[] fisrtStringArray = firstString.toCharArray();
        char [] secondStringArray = secondString.toCharArray();
        Arrays.sort(fisrtStringArray);
        Arrays.sort(secondStringArray);

        return Arrays.equals(fisrtStringArray, secondStringArray);
    }
    public static void main(String args []) {
        String str1 = "listen";
        String str2 = "silent";

        if (checkAnagram(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }
}
