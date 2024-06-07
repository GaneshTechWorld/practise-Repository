package com.example.Practice.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Other checked exceptions are SQLException,IOException,ClassNotFoundException,NoSuchMethodException,NoSuchFieldException etc
public class CheckedExceptionEx {
    public static void main(String args[]) throws FileNotFoundException {
        try {
            File file = new File("nonexistentfile.txt");
            Scanner scanner = new Scanner(file);
            scanner.close();
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
    }
}
