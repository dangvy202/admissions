package com.sch.student.service.Impl;

import com.sch.student.entity.StudentEnrollEntity;
import com.sch.student.entity.StudentReportEntity;
import com.sch.student.pojo.Student;
import com.sch.student.repository.StudentEnrollRepository;
import com.sch.student.service.StudentEnrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentEnrollServiceImpl implements StudentEnrollService {

    @Autowired
    private StudentEnrollRepository studentEnrollRepository;

    @Override
    public void saveStudent(StudentEnrollEntity studentEnroll) {
        studentEnrollRepository.save(studentEnroll);
    }

    @Override
    public StudentEnrollEntity setStudentEnroll(Student studentEnroll, StudentReportEntity userReport) {
        long millis=System.currentTimeMillis();
        Date dateNow = new Date(millis);

        StudentEnrollEntity studentEnrollInfo = StudentEnrollEntity.builder()
                .otherSubject1th(studentEnroll.getUserEnroll().getOtherSubject1th().toString())
                .otherSubject2th(studentEnroll.getUserEnroll().getOtherSubject2th().toString())
                .studentReport(userReport)
                .createEnroll(dateNow)
                .modifyEnroll(dateNow)
                .build();
        return studentEnrollInfo;
    }
}
