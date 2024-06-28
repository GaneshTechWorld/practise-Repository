package com.example.Practice.maping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

  /*  @Mapping(source = "studentId", target = "studentId")
    @Mapping(source = "studentName", target = "studentName")
    @Mapping(source = "collegeStudentSubjects", target = "univercityStudentSubjects")
    Univercity collegeToUnivercity(College college);*/
}