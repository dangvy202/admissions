package com.sch.student.service;

import com.sch.student.entity.CategoriesEntity;
import com.sch.student.entity.StudentEntity;
import com.sch.student.entity.StudentOptionEntity;
import com.sch.student.entity.StudentReportEntity;
import com.sch.student.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface StudentOptionService {
    void saveStudent(StudentOptionEntity studentOption);
    Optional<StudentOptionEntity> findOptionById(Long id);
    StudentOptionEntity setStudentOption(Student studentOption, StudentReportEntity userReport);
}
