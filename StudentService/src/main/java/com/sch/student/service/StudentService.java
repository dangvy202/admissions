package com.sch.student.service;

import com.sch.student.entity.StudentEntity;
import com.sch.student.pojo.Student;
import com.sch.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface StudentService{
    void saveStudent(StudentEntity studentInfo);
    Optional<StudentEntity> findStudentById(Long id);
    StudentEntity setUserInfomation(Student student);
}
