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
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/admissions")
@Validated
public class StudentController {

    private StudentReportServiceImpl studentReportServiceImpl;
    private StudentServiceImpl studentServiceImpl;
    private StudentInfoClassServiceImpl studentInfoClassServiceImpl;
    private StudentEnrollServiceImpl studentEnrollServiceImpl;
    private StudentOptionServiceImpl studentOptionServiceImpl;
    private CategoriesServiceImpl categoriesServiceImpl;
    private ApplicationFormServiceImpl applicationFormServiceImpl;

    public StudentController(ApplicationFormServiceImpl applicationFormServiceImpl ,CategoriesServiceImpl categoriesServiceImpl , StudentOptionServiceImpl studentOptionServiceImpl , StudentEnrollServiceImpl studentEnrollServiceImpl,StudentInfoClassServiceImpl studentInfoClassServiceImpl, StudentReportServiceImpl studentReportServiceImpl,StudentServiceImpl studentServiceImpl){
        this.studentServiceImpl = studentServiceImpl;
        this.studentReportServiceImpl = studentReportServiceImpl;
        this.studentInfoClassServiceImpl = studentInfoClassServiceImpl;
        this.studentEnrollServiceImpl = studentEnrollServiceImpl;
        this.studentOptionServiceImpl = studentOptionServiceImpl;
        this.categoriesServiceImpl = categoriesServiceImpl;
        this.applicationFormServiceImpl = applicationFormServiceImpl;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Map<String,List>> editEnrollmentInfomation(@PathVariable("id") Long idUser){
        List<ApplicationFormEntity> applicationFormEdit = applicationFormServiceImpl.findEnrollInfomation(idUser);
        Map<String,List>  enrollmenetInfoEdit = new HashMap<>();
        enrollmenetInfoEdit.put("Admissions",applicationFormEdit);
        return new ResponseEntity<>(enrollmenetInfoEdit,HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateEnrollmentInfomation(){
        return null;
    }

    @PostMapping("/setInfo")
    public ResponseEntity<String> saveInfoStudent(@RequestBody Student userRequest) throws Exception {
        try{
            StudentEntity userInfo = studentServiceImpl.setUserInfomation(userRequest);
            StudentReportEntity userReport = studentReportServiceImpl.setStudentReport(userRequest,userInfo);
            StudentInfoClassEntity userInfoClass = studentInfoClassServiceImpl.setStudentInfoClass(userRequest,userReport);
            StudentEnrollEntity userEnroll = studentEnrollServiceImpl.setStudentEnroll(userRequest,userReport);
            StudentOptionEntity userOption = studentOptionServiceImpl.setStudentOption(userRequest,userReport);
            ApplicationFormEntity applicationFormResult = applicationFormServiceImpl.setStudentEnroll(userInfo,userReport,userOption,userInfoClass,userEnroll);
            if(!applicationFormResult.toString().isEmpty() && !userInfo.toString().isEmpty() && !userReport.toString().isEmpty() && !userInfoClass.toString().isEmpty() && !userEnroll.toString().isEmpty()){
                studentServiceImpl.saveStudent(userInfo);
                studentReportServiceImpl.saveStudent(userReport);
                studentInfoClassServiceImpl.saveStudent(userInfoClass);
                studentEnrollServiceImpl.saveStudent(userEnroll);
                studentOptionServiceImpl.saveStudent(userOption);
                applicationFormServiceImpl.saveStudent(applicationFormResult);
                return new ResponseEntity<>(SuccessApi.SCH_SUCCESS_SAVE,HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>(ErrorApi.SCH_ERROR_EMPTY, HttpStatus.OK);
            }
        }
        catch(Exception ex){
            return new ResponseEntity<>(ErrorApi.SCH_ERROR_REQ_EMPTY,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
