package com.sch.student.service;

import com.sch.student.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplicationFormService {
    List<ApplicationFormEntity> findEnrollInfomation(Long id);
    void saveStudent(ApplicationFormEntity applicationForm);
    ApplicationFormEntity setStudentEnroll(SubjectEntity subject,AccountEntity account , StudentEntity user, StudentReportEntity userReport, StudentOptionEntity userOption, StudentInfoClassEntity userClass,StudentEnrollEntity userEnroll);
}
