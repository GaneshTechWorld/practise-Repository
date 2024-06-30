package com.example.Practice;

import lombok.Data;

@Data
class Course{
    int courseId;
    String courseName;
}

public class TernaryOperator {
    public static void main(String[] args) {

/*       int score = 90;
       String grade = (score > 95 && score <=100) ? "A+" :
                      (score > 90 && score <=95) ? "A" :
                      (score > 85 && score <=90) ? "B+" :
                      (score > 80 && score <=85) ? "B" : "D";
       System.out.print(grade);

       int number = 13;
       String result = (number %2 == 0) ? number+" Is Even" : number+"Number Is Odd";
        System.out.print(result);*/
      /*  Course a = new Course();
        Course b = new Course();
        a.setCourseId(1);
        a.setCourseName("Ganesh");
        b.setCourseId(1);
        //b.setCourseName("Ganesh");
        System.out.print(a.equals(b));*/

      // String value = (!name.isEmpty()) ? "String is not empty" : "String is empty";

/*        Course a = new Course();
       String aCourseName =  (a.getCourseName() != null) ? a.getCourseName() : "No Course";
      System.out.print(aCourseName);*/

    }
}
