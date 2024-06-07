package com.example.service;

import com.example.dto.StudentReqDto;
import com.example.entity.StudentEntity;
import com.example.exception.StudentNotFoundException;
import com.example.repository.StudentRepository;
import com.example.translator.StudentTranslator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentTranslator studentTranslator;
    @Autowired
    StudentRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    public List<StudentReqDto> getStudentInfo() {
        List<StudentEntity> studentList = repo.findAll();
        return studentTranslator.getDtoFromEntity(studentList);

    }

    public Object saveSingleStudent(StudentReqDto studentRequest) {

        Object data = studentTranslator.getEntity(studentRequest);
        if (data instanceof StudentEntity) {
            StudentEntity student = (StudentEntity) data;
            repo.save(student);
            return "student Record Saved Succesfully...";
        }
        if (data instanceof StringBuilder) {
            return (StringBuilder) data;
        }
        return null;
    }

    public String updateSingleStudent(StudentReqDto studentRequest,int id) throws StudentNotFoundException {
        StudentEntity existingStudent = findStudentById(id);
        if(existingStudent != null) {
            if (id > 0 && id != 0 && studentRequest != null) {
                modelMapper.map(studentRequest, existingStudent);
                repo.save(existingStudent);
                return "Record Update Succesfully...";
            } else
                return "Pease check id or stident info";
        } else
            return "Student Not For given id";

    }
    public StudentEntity findStudentById(int id) throws StudentNotFoundException {
        return repo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    public String deleteSingleStudent(int id){
       if(id > 0  && id != 0){
          if(repo.existsById(id)){
              repo.deleteById(id);
              return "Record Deleted Succesfully...";
          }else{
              return "Record Not Found for this id...";
          }
       }
        return null;
    }
}

