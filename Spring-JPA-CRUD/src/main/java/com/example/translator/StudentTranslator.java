package com.example.translator;

import com.example.dto.StudentReqDto;
import com.example.entity.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentTranslator {
    public Object getEntity(StudentReqDto requestDto) {
        StudentEntity studentEntity = new StudentEntity();
        if(requestDto != null){
            if(requestDto.getMobile().length() == 10 && requestDto.getMobile().matches(("\\d{10}"))){
                studentEntity.setMobileNumber(requestDto.getMobile());
            }else {
                return "Please Enter Number in proper Format";
            }
            if(requestDto.getName().matches("^[a-zA-Z]+( [a-zA-Z]+)+( [a-zA-Z]+)$")){
                studentEntity.setStudentName(requestDto.getName());
            } else {
                return "Please Enter Name in proper Format";
            }
            return studentEntity;
        }
            return "No Records to Save...";
    }

    public List<StudentReqDto> getDtoFromEntity(List<StudentEntity> studentList) {
        List<StudentReqDto> studentRequestList = new ArrayList<>();
        if(!studentList.isEmpty()) {
            for (StudentEntity studentEntity : studentList) {
                StudentReqDto studentRequest = new StudentReqDto();
                studentRequest.setName(studentEntity.getStudentName());
                studentRequest.setMobile(studentEntity.getMobileNumber());
                studentRequestList.add(studentRequest);
            }
        }
        return studentRequestList;
    }

}
