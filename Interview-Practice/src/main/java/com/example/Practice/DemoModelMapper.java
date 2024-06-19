package com.example.Practice;

import lombok.Data;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.PropertyMap;

import java.util.Arrays;
@Data
class College {
    private Integer collegeStudentId;
    private  String studentName;
}
@Data
class Univercity{
    private Integer univercityStudentId;
    private String studentName;
}
public class DemoModelMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public List<Univercity> mapping(List<College> collegeStudentList,List<Univercity> univercityList){
        System.out.println("1 College Student List : "+collegeStudentList);
        Type listType = new TypeToken<List<Univercity>>() {}.getType();
        modelMapper.addMappings(new PropertyMap<College, Univercity>() {
            @Override
            protected void configure() {
                map().setUnivercityStudentId(source.getCollegeStudentId()); // Override studentUnivercityId with studentCollegeId
            }});
        List<Univercity>  univercityStudentList = modelMapper.map(collegeStudentList, listType);
        return univercityStudentList;
    }

    public static void main(String[] args) {

        College collegeStudent1 = new College();
        collegeStudent1.setCollegeStudentId(1);
        collegeStudent1.setStudentName("Clg Name 1 - Ganesh Chaudhary");

        College collegeStudent2 = new College();
        collegeStudent2.setCollegeStudentId(2);
        collegeStudent2.setStudentName("Clg Name 2 - Mohit Mahajan");

        Univercity univercityStudent1 = new Univercity();
        univercityStudent1.setUnivercityStudentId(null);
        univercityStudent1.setStudentName("Uni Name 1 - Ganu Chaudhary");

        Univercity univercityStudent2 = new Univercity();
        univercityStudent2.setUnivercityStudentId(null);
        univercityStudent2.setStudentName("Uni Name 2 - Ganu Mahajan");

        //Arrays.asList(collegeStudent1,collegeStudent2);
        // Arrays.asList(univercityStudent1,univercityStudent2);
        DemoModelMapper d = new DemoModelMapper();
       List<Univercity>  univercities = d.mapping(Arrays.asList(collegeStudent1,collegeStudent2),Arrays.asList(univercityStudent1,univercityStudent2));
       univercities.forEach(student->{System.out.print(student);});
    }
}
