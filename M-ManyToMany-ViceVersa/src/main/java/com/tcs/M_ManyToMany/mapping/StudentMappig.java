package com.tcs.M_ManyToMany.mapping;

import com.tcs.M_ManyToMany.dto.StudentRequest;
import com.tcs.M_ManyToMany.dto.StudentResponse;
import com.tcs.M_ManyToMany.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMappig {
    StudentMappig INSTANCE = Mappers.getMapper(StudentMappig.class);
    StudentResponse studentEntityToStudentResponse(Student student);
    void updateStudentFromRequest(StudentRequest studentRequest, @MappingTarget Student student);
}
