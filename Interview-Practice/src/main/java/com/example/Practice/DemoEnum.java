package com.example.Practice;

enum MovieStatus {
    RELEASED,
    UPCOMING,
    CANCELLED
}
public class DemoEnum {

    public static void main(String[] args) {
             MovieStatus s
                = MovieStatus.valueOf("released");
         System.out.print(s);
    }
}
