package com.sch.student.controller;

import com.sch.student.constant.ErrorApi;
import com.sch.student.constant.SuccessApi;
import com.sch.student.entity.*;
import com.sch.student.pojo.Student;
import com.sch.student.repository.StudentEnrollRepository;
import com.sch.student.service.Impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
@Validated
public class StudentController {

    private StudentReportServiceImpl studentReportServiceImpl;
    private StudentServiceImpl studentServiceImpl;
    private StudentInfoClassServiceImpl studentInfoClassServiceImpl;
    private StudentEnrollServiceImpl studentEnrollServiceImpl;
    private StudentOptionServiceImpl studentOptionServiceImpl;
    private CategoriesServiceImpl categoriesServiceImpl;

    public StudentController(CategoriesServiceImpl categoriesServiceImpl , StudentOptionServiceImpl studentOptionServiceImpl , StudentEnrollServiceImpl studentEnrollServiceImpl,StudentInfoClassServiceImpl studentInfoClassServiceImpl, StudentReportServiceImpl studentReportServiceImpl,StudentServiceImpl studentServiceImpl){
        this.studentServiceImpl = studentServiceImpl;
        this.studentReportServiceImpl = studentReportServiceImpl;
        this.studentInfoClassServiceImpl = studentInfoClassServiceImpl;
        this.studentEnrollServiceImpl = studentEnrollServiceImpl;
        this.studentOptionServiceImpl = studentOptionServiceImpl;
        this.categoriesServiceImpl = categoriesServiceImpl;
    }

    @PostMapping("/setInfo")
    public ResponseEntity<String> saveInfoStudent(@RequestBody Student userRequest) throws Exception {
        StudentEntity userInfo = studentServiceImpl.setUserInfomation(userRequest);
        StudentReportEntity userReport = studentReportServiceImpl.setStudentReport(userRequest,userInfo);
        StudentInfoClassEntity userInfoClass = studentInfoClassServiceImpl.setStudentInfoClass(userRequest,userReport);
        StudentEnrollEntity userEnroll = studentEnrollServiceImpl.setStudentEnroll(userRequest,userReport);
        StudentOptionEntity userOption = studentOptionServiceImpl.setStudentOption(userRequest,userReport);
        if(!userInfo.toString().isEmpty() && !userReport.toString().isEmpty() && !userInfoClass.toString().isEmpty() && !userEnroll.toString().isEmpty()){
            studentServiceImpl.saveStudent(userInfo);
            studentReportServiceImpl.saveStudent(userReport);
            studentInfoClassServiceImpl.saveStudent(userInfoClass);
            studentEnrollServiceImpl.saveStudent(userEnroll);
            studentOptionServiceImpl.saveStudent(userOption);
            return new ResponseEntity<>(SuccessApi.SCH_SUCCESS_SAVE,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(ErrorApi.SCH_ERROR_EMPTY, HttpStatus.OK);
        }
    }
}
