package com.sch.student.service;

import com.sch.student.entity.StudentEntity;
import com.sch.student.entity.SubjectEntity;
import com.sch.student.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface SubjectService {
    void saveSubject(SubjectEntity subject);
    Optional<SubjectEntity> findSubjectById(Long id);
    SubjectEntity setSubjectInfomation(Student student);
}
