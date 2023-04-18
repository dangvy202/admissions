package com.sch.student.service.Impl;

import com.sch.student.entity.StudentEntity;
import com.sch.student.entity.StudentInfoClassEntity;
import com.sch.student.entity.StudentReportEntity;
import com.sch.student.pojo.Student;
import com.sch.student.repository.StudentInfoClassRepository;
import com.sch.student.service.StudentInfoClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class StudentInfoClassServiceImpl implements StudentInfoClassService {
    @Autowired
    private StudentInfoClassRepository studentInfoClassRepository;
    @Override
    public void saveStudent(StudentInfoClassEntity studentInfo) {
        studentInfoClassRepository.save(studentInfo);
    }

    @Override
    public Optional<StudentInfoClassEntity> findInfoClassById(Long id){
        return studentInfoClassRepository.findById(id);
    }

    @Override
    public StudentInfoClassEntity setStudentInfoClass(Student studentInfoClass, StudentReportEntity userReport) {
        long millis=System.currentTimeMillis();
        Date dateNow = new Date(millis);

        StudentInfoClassEntity userInfoClass = StudentInfoClassEntity.builder()
                .grade6TH(studentInfoClass.getUserInfoClass().getGrade6TH())
                .grade7TH(studentInfoClass.getUserInfoClass().getGrade7TH())
                .grade8TH(studentInfoClass.getUserInfoClass().getGrade8TH())
                .grade9TH(studentInfoClass.getUserInfoClass().getGrade9TH())
                .conductCertificate6TH(studentInfoClass.getUserInfoClass().getConductCertificate6TH())
                .conductCertificate7TH(studentInfoClass.getUserInfoClass().getConductCertificate7TH())
                .conductCertificate8TH(studentInfoClass.getUserInfoClass().getConductCertificate8TH())
                .conductCertificate9TH(studentInfoClass.getUserInfoClass().getConductCertificate9TH())
                .studentReport(userReport)
                .createInfoClass(dateNow)
                .modifyInfoClass(dateNow)
                .build();
        return userInfoClass;
    }
}
