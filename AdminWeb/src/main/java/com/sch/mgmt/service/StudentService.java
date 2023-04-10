package com.sch.student.service;

import com.sch.student.entity.StudentEntity;
import com.sch.student.pojo.Student;
import com.sch.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public interface StudentService{
    void saveStudent(StudentEntity studentInfo);

    StudentEntity setUserInfomation(Student student);
}
