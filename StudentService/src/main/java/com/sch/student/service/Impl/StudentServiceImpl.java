package com.sch.student.service.Impl;

import com.sch.student.entity.StudentEntity;
import com.sch.student.repository.StudentRepository;
import com.sch.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(StudentEntity studentInfo){
        studentRepository.save(studentInfo);
    }
}
