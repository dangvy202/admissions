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
import java.util.Optional;

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
    public Optional<StudentOptionEntity> findOptionById(Long id){
        return studentOptionRepository.findById(id);
    }

    @Override
    public StudentOptionEntity setStudentOption(Student studentRequest, StudentReportEntity userReport) {
        long millis=System.currentTimeMillis();
        Date dateNow = new Date(millis);

        StudentOptionEntity studentOption = StudentOptionEntity.builder()
                .math(studentRequest.getUserOption().getMath())
                .informaticsInformatics(studentRequest.getUserOption().getInformaticsInformatics())
                .informaticsMath(studentRequest.getUserOption().getInformaticsMath())
                .physicsMath(studentRequest.getUserOption().getPhysicsPhysics())
                .physicsMath(studentRequest.getUserOption().getPhysicsMath())
                .chemistry(studentRequest.getUserOption().getChemistry())
                .biology(studentRequest.getUserOption().getBiology())
                .english(studentRequest.getUserOption().getEnglish())
                .literature(studentRequest.getUserOption().getLiterature())
                .mathLN(studentRequest.getUserOption().getMathLN())
                .physicsPhysicsLN(studentRequest.getUserOption().getPhysicsPhysicsLN())
                .physicsMathLN(studentRequest.getUserOption().getPhysicsMathLN())
                .chemistryChemistryLN(studentRequest.getUserOption().getChemistryChemistryLN())
                .chemistryMathLN(studentRequest.getUserOption().getChemistryMathLN())
                .biologyBiologyLN(studentRequest.getUserOption().getBiologyBiologyLN())
                .biologyMathLN(studentRequest.getUserOption().getBiologyMathLN())
                .englishLN(studentRequest.getUserOption().getEnglishLN())
                .literatureLN(studentRequest.getUserOption().getLiteratureLN())
                .report(userReport)
                .createOption(dateNow)
                .modifyOption(dateNow)
                .build();
        return studentOption;
    }


}
