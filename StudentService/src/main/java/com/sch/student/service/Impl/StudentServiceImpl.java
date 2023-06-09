package com.sch.student.service.Impl;

import com.sch.student.entity.StudentEntity;
import com.sch.student.pojo.Student;
import com.sch.student.repository.StudentRepository;
import com.sch.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(StudentEntity studentInfo){

        studentRepository.save(studentInfo);
    }

    @Override
    public Optional<StudentEntity> findStudentById(Long id){
        return studentRepository.findById(id);
    }

    @Override
    public StudentEntity setUserInfomation(Student userRequest){
        long millis=System.currentTimeMillis();
        Date dateNow = new Date(millis);
        StudentEntity userInfo = StudentEntity.builder()
                .firstName(userRequest.getUserInfo().getFirstName())
                .lastName(userRequest.getUserInfo().getLastName())
                .placeOfBirth(userRequest.getUserInfo().getPlaceOfBirth())
                .province(userRequest.getUserInfo().getProvince())
                .district(userRequest.getUserInfo().getDistrict())
                .ward(userRequest.getUserInfo().getWard())
                .address(userRequest.getUserInfo().getAddress())
                .birthday(userRequest.getUserInfo().getBirthday())
                .sex(userRequest.getUserInfo().getSex())
                .ethnicity(userRequest.getUserInfo().getEthnicity())
                .identifyInfo(userRequest.getUserInfo().getIdentifyInfo())
                .nationality(userRequest.getUserInfo().getNationality())
                .phoneNumber(userRequest.getUserInfo().getPhoneNumber())
                .landlinePhoneNumber(userRequest.getUserInfo().getLandlinePhoneNumber())
                .optionPhone(userRequest.getUserInfo().getOptionPhone())
                .createAccount(dateNow)
                .modifyAccount(dateNow)
                .build();
        return userInfo;
    }
}
