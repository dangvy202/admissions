package com.sch.student.service.Impl;

import com.sch.student.entity.SubjectEntity;
import com.sch.student.pojo.Student;
import com.sch.student.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectServiceImpl implements com.sch.student.service.SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public void saveSubject(SubjectEntity subject) {
        subjectRepository.save(subject);
    }

    @Override
    public Optional<SubjectEntity> findSubjectById(Long id){
        return subjectRepository.findById(id);
    }

    @Override
    public SubjectEntity setSubjectInfomation(Student student) {
        SubjectEntity subject = SubjectEntity.builder()
                .math(student.getSubject().getMath())
                .literature(student.getSubject().getLiterature())
                .informatics(student.getSubject().getInformatics())
                .physics(student.getSubject().getPhysics())
                .chemistry(student.getSubject().getChemistry())
                .english(student.getSubject().getEnglish())
                .biology(student.getSubject().getBiology())
                .build();
        return subject;
    }
}
