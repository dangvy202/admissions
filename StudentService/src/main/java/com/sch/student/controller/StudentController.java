package com.sch.student.controller;

import com.sch.student.constant.ErrorApi;
import com.sch.student.constant.SuccessApi;
import com.sch.student.entity.StudentEntity;
import com.sch.student.pojo.Student;
import com.sch.student.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private StudentServiceImpl studentServiceImpl;

    public StudentController( StudentServiceImpl studentServiceImpl){
        this.studentServiceImpl = studentServiceImpl;
    }

    @PostMapping("/setInfo")
    public ResponseEntity<String> saveInfoStudent(@RequestBody Student userRequest){

        long millis=System.currentTimeMillis();
        Date dateNow = new Date(millis);

        StudentEntity userInfo = StudentEntity.builder()
                .firstName(userRequest.getUserInfo().getFirstName())
                .lastName(userRequest.getUserInfo().getLastName())
                .password(userRequest.getUserInfo().getPassword())
                .email(userRequest.getUserInfo().getEmail())
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
        if(!userInfo.toString().isEmpty()){
            studentServiceImpl.saveStudent(userInfo);
            return new ResponseEntity<>(SuccessApi.SCH_SUCCESS_SAVE,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(ErrorApi.SCH_ERROR_EMPTY, HttpStatus.OK);
        }
    }
}
