package com.example.Practice.maping;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
class College{
    private int studentId;
    private String studentName;
    private List<String> collegeStudentSubjects ;
}
@Data
class Univercity{
    private int studentId;
    private String studentName;
    private List<StringBuilder> univercityStudentSubjects ;
}

public class MapStructExample {
    public static void main(String[] args) {
       /* College collegeStudent = new College();
        collegeStudent.setStudentId(1);
        collegeStudent.setStudentName("Middle Mohan");
        collegeStudent.setCollegeStudentSubjects(Arrays.asList("M1","M2","M3"));
        Univercity univercityStudent = StudentMapper.INSTANCE.collegeToUnivercity(collegeStudent);
        System.out.println("University Student Id: " + univercityStudent.getStudentId());
        System.out.println("University Student Name: " + univercityStudent.getStudentName());
        System.out.println("University Student Subjects: " + univercityStudent.getUnivercityStudentSubjects());
*/    }
}
