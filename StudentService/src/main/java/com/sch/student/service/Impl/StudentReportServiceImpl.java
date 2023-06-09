package com.sch.student.service.Impl;

import com.sch.student.entity.StudentEntity;
import com.sch.student.entity.StudentReportEntity;
import com.sch.student.pojo.Student;
import com.sch.student.repository.StudentReportRepository;
import com.sch.student.service.StudentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class StudentReportServiceImpl implements StudentReportService {

    @Autowired
    private StudentReportRepository studentRepository;

    @Override
    public void saveStudent(StudentReportEntity studentReport){
        studentRepository.save(studentReport);
    }

    @Override
    public Optional<StudentReportEntity> findReportById(Long id){
        return studentRepository.findById(id);
    }

    @Override
    public StudentReportEntity setStudentReport(Student userRequest,StudentEntity userInfo){
        long millis=System.currentTimeMillis();
        Date dateNow = new Date(millis);

        StudentReportEntity userReport = StudentReportEntity.builder()
                .schoolPassed(userRequest.getUserReport().getSchoolPassed())
                .nameClass(userRequest.getUserReport().getNameClass())
                .ward(userRequest.getUserReport().getWard())
                .province(userRequest.getUserReport().getProvince())
                .district(userRequest.getUserReport().getDistrict())
                .schoolAddress(userRequest.getUserReport().getSchoolPassed())
                .academicAbility(userRequest.getUserReport().getAcademicAbility())
                .student(userInfo)
                .createReport(dateNow)
                .modifyReport(dateNow)
                .build();
        return userReport;
    }
}
