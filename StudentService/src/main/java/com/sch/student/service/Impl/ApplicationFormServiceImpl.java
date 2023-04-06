package com.sch.student.service.Impl;

import com.sch.student.entity.*;
import com.sch.student.pojo.Student;
import com.sch.student.repository.ApplicationFormRepository;
import com.sch.student.service.ApplicationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationFormServiceImpl implements ApplicationFormService {
    @Autowired
    private ApplicationFormRepository applicationFormRepository;

    @Override
    public List<ApplicationFormEntity> findEnrollInfomation(Long id){
        List<ApplicationFormEntity> applicationFormInfomation = applicationFormRepository.findEnrollInfomation(id);
        return applicationFormInfomation;
    }

    @Override
    public void saveStudent(ApplicationFormEntity applicationForm) {
        applicationFormRepository.save(applicationForm);
    }

    @Override
    public ApplicationFormEntity setStudentEnroll(StudentEntity user, StudentReportEntity userReport, StudentOptionEntity userOption, StudentInfoClassEntity userClass, StudentEnrollEntity userEnroll) {
        long millis=System.currentTimeMillis();
        Date dateNow = new Date(millis);

        ApplicationFormEntity applicationForm = ApplicationFormEntity.builder()
                .schUser(user)
                .schReport(userReport)
                .schOption(userOption)
                .schInfoClass(userClass)
                .schEnroll(userEnroll)
                .createApplication(dateNow)
                .modifyApplication(dateNow)
                .build();
        return applicationForm;
    }
}
