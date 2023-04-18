package com.sch.student.service;

import com.sch.student.entity.StudentEntity;
import com.sch.student.entity.StudentReportEntity;
import com.sch.student.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface StudentReportService {
    void saveStudent(StudentReportEntity studentReport);
    Optional<StudentReportEntity> findReportById(Long id);
    StudentReportEntity setStudentReport(Student studentReport,StudentEntity userInfo);
}
