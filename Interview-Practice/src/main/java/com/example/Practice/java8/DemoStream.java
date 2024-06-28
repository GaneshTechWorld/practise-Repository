package com.example.Practice.java8;
import lombok.Data;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
class Student {
     private Integer studentId;
     private String studentName;
     List<String> studentSubject;
}
public class DemoStream {
    List<Student> getStudentList(){
        Student stud1 = new Student();
        stud1.setStudentId(1);
        stud1.setStudentName("anesh Chaudhary");
        stud1.setStudentSubject(Arrays.asList("Physic","Chemistry","Math"));
        Student stud2 = new Student();
        stud2.setStudentId(2);
        stud2.setStudentName("Ganesh Mahajan");
        stud2.setStudentSubject(Arrays.asList("Physic","Chemistry","Biology"));
        Student stud3 = new Student();
        stud3.setStudentId(3);
        stud3.setStudentName("Ganesh Shinde");
        stud3.setStudentSubject(Arrays.asList("Physic","Chemistry","AMath","Biology"));
        return  Arrays.asList(stud1,stud2,stud3);
    }
    public static void main(String[] args) {
        DemoStream demoStream = new DemoStream();
        demoStream.getStudentList().stream().map(Student::getStudentName).forEach(System.out::println);
    }
}
