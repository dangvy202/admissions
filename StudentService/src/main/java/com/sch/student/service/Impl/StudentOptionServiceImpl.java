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
                .aspiration1th(getNameCategoryByStudentOption(studentRequest,"aspiration1TH"))
                .aspiration2th(getNameCategoryByStudentOption(studentRequest,"aspiration2TH"))
                .aspiration3th(getNameCategoryByStudentOption(studentRequest,"aspiration3TH"))
                .aspiration4th(getNameCategoryByStudentOption(studentRequest,"aspiration4TH"))
                .aspiration5th(getNameCategoryByStudentOption(studentRequest,"aspiration5TH"))
//                .category(categories)
                .studentReport(userReport)
                .createOption(dateNow)
                .modifyOption(dateNow)
                .build();
        return studentOption;
    }

    @Override
    public String getNameCategoryByStudentOption(Student studentRequest,String aspiration) {
        CategoriesEntity categories = new CategoriesEntity();
        switch (aspiration){
            case "aspiration1TH":
                categories = categoriesServiceImpl.findNameSubjectCategories(studentRequest.getUserOption().getAspiration1th());
                break;
            case "aspiration2TH":
                categories = categoriesServiceImpl.findNameSubjectCategories(studentRequest.getUserOption().getAspiration2th());
                break;
            case "aspiration3TH":
                categories = categoriesServiceImpl.findNameSubjectCategories(studentRequest.getUserOption().getAspiration3th());
                break;
            case "aspiration4TH":
                categories = categoriesServiceImpl.findNameSubjectCategories(studentRequest.getUserOption().getAspiration4th());
                break;
            case "aspiration5TH":
                categories = categoriesServiceImpl.findNameSubjectCategories(studentRequest.getUserOption().getAspiration5th());
                break;
        }
        return categories.getNameSubject();
    }
}
