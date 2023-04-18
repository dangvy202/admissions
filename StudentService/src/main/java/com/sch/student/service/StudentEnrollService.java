package com.sch.student.service;

import com.sch.student.entity.StudentEnrollEntity;
import com.sch.student.entity.StudentInfoClassEntity;
import com.sch.student.entity.StudentReportEntity;
import com.sch.student.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface StudentEnrollService {
    void saveStudent(StudentEnrollEntity studentEnroll);
    StudentEnrollEntity setStudentEnroll(Student studentEnroll, StudentReportEntity userReport);
    Optional<StudentEnrollEntity> findEnrollById(Long id);
}
