package com.example.Practice;

import lombok.Data;

@Data
class Student{
    private int studentId;
    private String studentName;
}
public class Demo {
    public static void main(String[] args) {

        Student stud = new Student();
        Student stud1 = new Student();
        Student stud3 = stud;
        stud.setStudentId(1);
        stud.setStudentName("Ram");
        stud1.setStudentId(1);
        stud1.setStudentName("Ram");
        System.out.println(stud.equals(stud1));
        System.out.println(stud.hashCode());
        System.out.println(stud3.hashCode());
        System.out.println(stud == stud1);
    }
}
