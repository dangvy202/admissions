package com.sch.student.service;

import com.sch.student.entity.StudentEntity;
import com.sch.student.entity.SubjectEntity;
import com.sch.student.pojo.Student;
import org.springframework.stereotype.Service;

@Service
public interface SubjectService {
    void saveSubject(SubjectEntity subject);

    SubjectEntity setSubjectInfomation(Student student);
}
