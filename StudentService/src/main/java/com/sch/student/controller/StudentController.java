package com.sch.student.controller;

import com.sch.student.constant.ErrorApi;
import com.sch.student.constant.SuccessApi;
import com.sch.student.dto.ImgDTO;
import com.sch.student.entity.*;
import com.sch.student.pojo.Student;
import com.sch.student.service.Impl.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
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
    private SubjectServiceImpl subjectServiceImpl;
    private AccountServiceImpl accountServiceImpl;
    private ImgServiceImpl imgServiceImpl;

    public StudentController(ImgServiceImpl imgServiceImpl,SubjectServiceImpl subjectServiceImpl ,AccountServiceImpl accountServiceImpl,ApplicationFormServiceImpl applicationFormServiceImpl ,CategoriesServiceImpl categoriesServiceImpl , StudentOptionServiceImpl studentOptionServiceImpl , StudentEnrollServiceImpl studentEnrollServiceImpl,StudentInfoClassServiceImpl studentInfoClassServiceImpl, StudentReportServiceImpl studentReportServiceImpl,StudentServiceImpl studentServiceImpl){
        this.studentServiceImpl = studentServiceImpl;
        this.studentReportServiceImpl = studentReportServiceImpl;
        this.studentInfoClassServiceImpl = studentInfoClassServiceImpl;
        this.studentEnrollServiceImpl = studentEnrollServiceImpl;
        this.studentOptionServiceImpl = studentOptionServiceImpl;
        this.categoriesServiceImpl = categoriesServiceImpl;
        this.applicationFormServiceImpl = applicationFormServiceImpl;
        this.accountServiceImpl = accountServiceImpl;
        this.subjectServiceImpl = subjectServiceImpl;
        this.imgServiceImpl = imgServiceImpl;
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

            StudentEntity userInfo = studentServiceImpl.setUserInfomation(userRequest);
            StudentReportEntity userReport = studentReportServiceImpl.setStudentReport(userRequest,userInfo);
            StudentInfoClassEntity userInfoClass = studentInfoClassServiceImpl.setStudentInfoClass(userRequest,userReport);
            StudentEnrollEntity userEnroll = studentEnrollServiceImpl.setStudentEnroll(userRequest,userReport);
            StudentOptionEntity userOption = studentOptionServiceImpl.setStudentOption(userRequest,userReport);
            AccountEntity account = accountServiceImpl.setAccountForApplicationForm(userRequest.getAccount().getIdentifierCode());
            SubjectEntity subject = subjectServiceImpl.setSubjectInfomation(userRequest);
            ApplicationFormEntity applicationFormResult = applicationFormServiceImpl.setStudentEnroll(subject,account,userInfo,userReport,userOption,userInfoClass,userEnroll);
            if(!subject.toString().isEmpty() && !account.toString().isEmpty() && !applicationFormResult.toString().isEmpty() && !userInfo.toString().isEmpty() && !userReport.toString().isEmpty() && !userInfoClass.toString().isEmpty() && !userEnroll.toString().isEmpty()){
                studentServiceImpl.saveStudent(userInfo);
                subjectServiceImpl.saveSubject(subject);
                studentReportServiceImpl.saveStudent(userReport);
                studentInfoClassServiceImpl.saveStudent(userInfoClass);
                studentEnrollServiceImpl.saveStudent(userEnroll);
                studentOptionServiceImpl.saveStudent(userOption);
                applicationFormServiceImpl.saveStudent(applicationFormResult);
                //send mail when success admission
                accountServiceImpl.sendMailVerifyAccount("ĐĂNG KÝ TUYỂN SINH THÀNH CÔNG","TRƯỜNG THPT NĂNG KHIẾU","<p>Dear "+account.getEmail()+",</p>",account,"");


                return new ResponseEntity<>(SuccessApi.SCH_SUCCESS_SAVE,HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>(ErrorApi.SCH_ERROR_EMPTY, HttpStatus.OK);
            }

    }

    @PostMapping("/img")
    public void upload(@RequestParam("identifierCode") String identifierCode,@RequestParam("imgFront") MultipartFile imgFront,@RequestParam("imgBack") MultipartFile imgBack , @RequestParam("imgUser") MultipartFile imgUser) throws IOException {
        AccountEntity account = accountServiceImpl.setAccountForApplicationForm(identifierCode);
        imgServiceImpl.uploadImgInFolder(account,imgFront,imgBack,imgUser);
    }


    @GetMapping("/img/download/{id}")
    @ResponseBody
    public ResponseEntity<?> showImage(@PathVariable("id") Long id)
            throws ServletException, IOException {
        byte[] img = imgServiceImpl.downloadImg(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(img);
    }
}
