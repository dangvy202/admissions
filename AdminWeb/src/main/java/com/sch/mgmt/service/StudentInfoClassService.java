package com.sch.student.service;

import com.sch.student.entity.StudentEntity;
import com.sch.student.entity.StudentInfoClassEntity;
import com.sch.student.entity.StudentReportEntity;
import com.sch.student.pojo.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentInfoClassService {
    void saveStudent(StudentInfoClassEntity studentReport);
    StudentInfoClassEntity setStudentInfoClass(Student studentReport, StudentReportEntity userReport);
}
