package com.sch.student.service.Impl;

import com.sch.student.entity.CategoriesEntity;
import com.sch.student.entity.StudentEnrollEntity;
import com.sch.student.entity.StudentOptionEntity;
import com.sch.student.entity.StudentReportEntity;
import com.sch.student.pojo.Student;
import com.sch.student.repository.CategoriesRepository;
import com.sch.student.repository.StudentOptionRepository;
import com.sch.student.service.StudentEnrollService;
import com.sch.student.service.StudentOptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class StudentOptionServiceImpl implements StudentOptionService {

    @Autowired
    private StudentOptionRepository studentOptionRepository;

    @Autowired
    private CategoriesServiceImpl categoriesServiceImpl;

    @Override
    public void saveStudent(StudentOptionEntity studentOption) {
        studentOptionRepository.save(studentOption);
    }

    @Override
    public StudentOptionEntity setStudentOption(Student studentRequest, StudentReportEntity userReport) {
        long millis=System.currentTimeMillis();
        Date dateNow = new Date(millis);

        StudentOptionEntity studentOption = StudentOptionEntity.builder()
                .mathCS1(studentRequest.getUserOption().getMathCS1())
                .literatureCS1(studentRequest.getUserOption().getLiteratureCS1())
                .informaticsCS1(studentRequest.getUserOption().getInformaticsCS1())
                .physicsCS1(studentRequest.getUserOption().getPhysicsCS1())
                .chemistryCS1(studentRequest.getUserOption().getChemistryCS1())
                .biologycs1(studentRequest.getUserOption().getBiologycs1())
                .englishCS1(studentRequest.getUserOption().getEnglishCS1())
                .mathCS2(studentRequest.getUserOption().getMathCS2())
                .literatureCS2(studentRequest.getUserOption().getLiteratureCS2())
                .informaticsCS2(studentRequest.getUserOption().getInformaticsCS2())
                .physicsCS2(studentRequest.getUserOption().getPhysicsCS2())
                .chemistryCS2(studentRequest.getUserOption().getChemistryCS2())
                .biologycs2(studentRequest.getUserOption().getBiologycs2())
                .englishCS2(studentRequest.getUserOption().getEnglishCS2())
//                .aspiration1th(getNameCategoryByStudentOption(studentRequest,"aspiration1TH"))
//                .aspiration2th(getNameCategoryByStudentOption(studentRequest,"aspiration2TH"))
//                .aspiration3th(getNameCategoryByStudentOption(studentRequest,"aspiration3TH"))
//                .aspiration4th(getNameCategoryByStudentOption(studentRequest,"aspiration4TH"))
//                .aspiration5th(getNameCategoryByStudentOption(studentRequest,"aspiration5TH"))
//                .category(categories)
                .studentReport(userReport)
                .createOption(dateNow)
                .modifyOption(dateNow)
                .build();
        return studentOption;
    }


}
