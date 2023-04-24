package com.sch.student.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sch.student.constant.ErrorApi;
import com.sch.student.constant.SuccessApi;
import com.sch.student.dto.AccountDTO;
import com.sch.student.dto.ImgDTO;
import com.sch.student.entity.*;
import com.sch.student.pojo.Account;
import com.sch.student.pojo.Student;
import com.sch.student.service.Impl.*;
import com.sch.student.util.ImageUtils;
import jakarta.annotation.Nullable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import netscape.javascript.JSObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.nio.file.Files;
import java.sql.Array;
import java.util.*;

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
    private PaymentServiceImpl paymentServiceImpl;

    public StudentController(PaymentServiceImpl paymentServiceImpl, ImgServiceImpl imgServiceImpl,SubjectServiceImpl subjectServiceImpl ,AccountServiceImpl accountServiceImpl,ApplicationFormServiceImpl applicationFormServiceImpl ,CategoriesServiceImpl categoriesServiceImpl , StudentOptionServiceImpl studentOptionServiceImpl , StudentEnrollServiceImpl studentEnrollServiceImpl,StudentInfoClassServiceImpl studentInfoClassServiceImpl, StudentReportServiceImpl studentReportServiceImpl,StudentServiceImpl studentServiceImpl){
        this.studentServiceImpl = studentServiceImpl;
        this.paymentServiceImpl = paymentServiceImpl;
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

    //GET INFOMATION OF SCH_IMG_INFOMATION AND ACCOUNT
    @GetMapping("/account/edit/{id}")
    public ResponseEntity<?> editAccountAndImgInfomation(@PathVariable("id") Long idUser){
        //find account
        AccountEntity account = accountServiceImpl.findAccountById(idUser).get();

        //find img
        ImgInfomationEntity img = imgServiceImpl.findImgByAccountId(idUser);

        byte[] imgParseFront = ImageUtils.decompressImage(img.getNamePathFront());
        byte[] imgParseBack = ImageUtils.decompressImage(img.getNamePathBack());
        byte[] imgParseUser = ImageUtils.decompressImage(img.getNamePathUser());

        img.setNamePathFront(imgParseFront);
        img.setNamePathBack(imgParseBack);
        img.setNamePathUser(imgParseUser);

        //set account List
        List<AccountEntity> schAccount = new ArrayList<>();
        schAccount.add(account);

        //set img List
        List<ImgInfomationEntity> schImgInfo = new ArrayList<>();
        schImgInfo.add(img);


        Map<String,List<?>> schAccountAndImg = new HashMap<>();
        schAccountAndImg.put("schAccount",  schAccount);
        schAccountAndImg.put("schImgInfo", schImgInfo);


        Map<String,Map<String,List<?>>> allAccountAndImg = new HashMap<>();
        allAccountAndImg.put("applicationFormEdit" , schAccountAndImg);
        return new ResponseEntity<>(allAccountAndImg,HttpStatus.OK);
    }

    //UPDATE INFOMATION OF ADMISSION(SCH_IMG_INFOMATION AND ACCOUNT)
    @PostMapping("/account/update/{id}")
    public ResponseEntity<String> updateAccountAndImg(@PathVariable("id") Long id,
                                                      @RequestParam("passWord") String password,
                                                      @RequestParam("email") String email,
                                                      @RequestParam("identifierCode") String identifierCode,
                                                      @RequestParam("imgFront") MultipartFile imgFront,
                                                      @RequestParam("imgBack") MultipartFile imgBack ,
                                                      @RequestParam("imgUser") MultipartFile imgUser
                                                      ) throws IOException {

//        ----------------------------------------------

        //find account
        AccountEntity account = accountServiceImpl.findAccountById(id).get();

        //set table sch_account
        AccountDTO accountSet = new AccountDTO();
        accountSet.setEmail(email);
        accountSet.setPassword(password);
        accountSet.setIdentifierCode(identifierCode);
        AccountEntity schAccountSet = accountServiceImpl.setAccountRequest(null,accountSet);

        //Map Student into Entity Enroll
        account.update(schAccountSet);

        //save account
        accountServiceImpl.registerAccount(account);

//        ----------------------------------------------

        //find img
        ImgInfomationEntity img = imgServiceImpl.findImgByAccountId(id);

        //set table img
        ImgInfomationEntity imgSet = imgServiceImpl.setImgInFolder(account,imgFront,imgBack,imgUser);

        //Map img DB
        img.update(imgSet);

        //save
        imgServiceImpl.saveImg(img);

        return new ResponseEntity<>("EDIT ACCOUNT SUCCESS",HttpStatus.OK);

    }

    //hỏi lai
//    @GetMapping("/allInfomation/{id}")
//    public ResponseEntity<List<ApplicationFormEntity>> listEnrollmentInfomation(@PathVariable("id") Long idUser){
//        List<ApplicationFormEntity> applicationForm = applicationFormServiceImpl.findApplicationByAccountId(idUser);
//
//        return new ResponseEntity<>(applicationForm,HttpStatus.OK);
//    }

    //GET INFOMATION OF ADMISSION(NOT SCH_IMG_INFOMATION AND ACCOUNT)
    @GetMapping("/infomation/edit/{id}")
    public ResponseEntity<Map<String,Map<String,List<?>>>> editEnrollmentInfomation(@PathVariable("id") Long idApplication){
        ApplicationFormEntity applicationFormEdit = applicationFormServiceImpl.findEnrollInfomation(idApplication);

        List<StudentEntity>  schUser = new ArrayList<>();
        schUser.add(applicationFormEdit.getSchUser());

        List<StudentReportEntity> schStudentReport = new ArrayList<>();
        schStudentReport.add(applicationFormEdit.getSchReport());

        List<StudentOptionEntity> schStudentOption = new ArrayList<>();
        schStudentOption.add(applicationFormEdit.getSchOption());

        List<StudentInfoClassEntity> schStudentInfoClass = new ArrayList<>();
        schStudentInfoClass.add(applicationFormEdit.getSchInfoClass());

        List<StudentEnrollEntity> schStudentEnroll = new ArrayList<>();
        schStudentEnroll.add(applicationFormEdit.getSchEnroll());

        List<AccountEntity> schAccount = new ArrayList<>();
        schAccount.add(applicationFormEdit.getSchAccount());

        List<SubjectEntity> schSubject = new ArrayList<>();
        schSubject.add(applicationFormEdit.getSubject());

        Map<String,List<?>> schApplicationForm = new HashMap<>();
        schApplicationForm.put("schUser",  schUser);
        schApplicationForm.put("schStudentReport", schStudentReport);
        schApplicationForm.put("schStudentOption", schStudentOption);
        schApplicationForm.put("schStudentInfoClass", schStudentInfoClass);
        schApplicationForm.put("schStudentEnroll", schStudentEnroll);
        schApplicationForm.put("schAccount", schAccount);
        schApplicationForm.put("schSubject", schSubject);
        Map<String,Map<String,List<?>>> allInfoFormStudent = new HashMap<>();
        allInfoFormStudent.put("applicationFormEdit" , schApplicationForm);
        return new ResponseEntity<>(allInfoFormStudent,HttpStatus.OK);
    }

    //UPDATE INFOMATION OF ADMISSION(NOT SCH_IMG_INFOMATION AND ACCOUNT)
    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateEnrollmentInfomation(@PathVariable("id") Long id,@RequestBody Student userRequest){
        //find id table schReport
        Optional<StudentReportEntity> schReport = studentReportServiceImpl.findReportById(id);

//        ---------------------------------------------

        //find id table sch enroll
        Optional<StudentEnrollEntity> schEnrollInfo = studentEnrollServiceImpl.findEnrollById(id);

        //set table sch_enroll
        StudentEnrollEntity schEnrollSet = studentEnrollServiceImpl.setStudentEnroll(userRequest,schReport.get());

        //Map Student into Entity Enroll
        schEnrollInfo.get().update(schEnrollSet);

        //Save Enroll
        studentEnrollServiceImpl.saveStudent(schEnrollInfo.get());

//        ------------------------------------------------

        //find id table info class
        Optional<StudentInfoClassEntity> schInfoClass = studentInfoClassServiceImpl.findInfoClassById(id);

        //set table sch info class
        StudentInfoClassEntity schInfoClassSet = studentInfoClassServiceImpl.setStudentInfoClass(userRequest,schReport.get());

        //Map Info Class Entity into
        schInfoClass.get().update(schInfoClassSet);

        //Save info Class
        studentInfoClassServiceImpl.saveStudent(schInfoClass.get());

//        -----------------------------------------------

        //find id table sch user
        Optional<StudentEntity> schUser = studentServiceImpl.findStudentById(id);

        //set table sch user
        StudentEntity schUserSet = studentServiceImpl.setUserInfomation(userRequest);

        //Map User Entity
        schUser.get().update(schUserSet);

        //Save User
        studentServiceImpl.saveStudent(schUser.get());

//      ---------------------------------------------------------

        //find id table option
        Optional<StudentOptionEntity> schOption = studentOptionServiceImpl.findOptionById(id);

        //set table sch option
        StudentOptionEntity schOptionSet = studentOptionServiceImpl.setStudentOption(userRequest,schReport.get());

        //Map Option Entity
        schOption.get().update(schOptionSet);

        //save option
        studentOptionServiceImpl.saveStudent(schOption.get());

//      --------------------------------------------------------

        //set table sch report
        StudentReportEntity schReportSet = studentReportServiceImpl.setStudentReport(userRequest,schUser.get());

        //Map Report Entity
        schReport.get().update(schReportSet);

        //save report
        studentReportServiceImpl.saveStudent(schReport.get());

//      ----------------------------------------------------------

        //find id table subject
        Optional<SubjectEntity> schSubject = subjectServiceImpl.findSubjectById(id);

        //set table sch subject
        SubjectEntity schSubjectSet = subjectServiceImpl.setSubjectInfomation(userRequest);

        //Map Subject Entity
        schSubject.get().update(schSubjectSet);

        //save subject
        subjectServiceImpl.saveSubject(schSubject.get());


        return new ResponseEntity<>("EDIT SUCCESS",HttpStatus.OK);
    }

    @GetMapping("/amount/{id}")
    public Double getAmmountAdmission(@PathVariable("id") String id){
        AccountEntity account = accountServiceImpl.findAccountByIdentifierCode(id);
        PaymentEntity payment = paymentServiceImpl.findPaymentByAccountId(account.getId());
        return payment.getAmount();
    }

    @PostMapping("/setInfo")
    public ResponseEntity<String> saveInfoStudent(@RequestBody Student userRequest) throws Exception {

            StudentEntity userInfo = studentServiceImpl.setUserInfomation(userRequest);
            StudentReportEntity userReport = studentReportServiceImpl.setStudentReport(userRequest,userInfo);
            StudentInfoClassEntity userInfoClass = studentInfoClassServiceImpl.setStudentInfoClass(userRequest,userReport);
            StudentEnrollEntity userEnroll = studentEnrollServiceImpl.setStudentEnroll(userRequest,userReport);
            StudentOptionEntity userOption = studentOptionServiceImpl.setStudentOption(userRequest,userReport);
            AccountEntity account = accountServiceImpl.setAccountForApplicationForm(userRequest.getAccount().getIdentifierCode());
            PaymentEntity payment = paymentServiceImpl.setPayment(userRequest.getUserOption(),account);
            SubjectEntity subject = subjectServiceImpl.setSubjectInfomation(userRequest);
            ApplicationFormEntity applicationFormResult = applicationFormServiceImpl.setStudentEnroll(subject,account,userInfo,userReport,userOption,userInfoClass,userEnroll);
            if(!payment.toString().isEmpty() && !subject.toString().isEmpty() && !account.toString().isEmpty() && !applicationFormResult.toString().isEmpty() && !userInfo.toString().isEmpty() && !userReport.toString().isEmpty() && !userInfoClass.toString().isEmpty() && !userEnroll.toString().isEmpty()){
                studentServiceImpl.saveStudent(userInfo);
                subjectServiceImpl.saveSubject(subject);
                studentReportServiceImpl.saveStudent(userReport);
                studentInfoClassServiceImpl.saveStudent(userInfoClass);
                studentEnrollServiceImpl.saveStudent(userEnroll);
                studentOptionServiceImpl.saveStudent(userOption);
                applicationFormServiceImpl.saveStudent(applicationFormResult);
                paymentServiceImpl.savePayment(payment);
                //send mail when success admission
                accountServiceImpl.sendMailVerifyAccount("","ĐĂNG KÝ TUYỂN SINH THÀNH CÔNG","TRƯỜNG THPT NĂNG KHIẾU","<p>Dear "+account.getEmail()+",</p>",account,"","");


                return new ResponseEntity<>(SuccessApi.SCH_SUCCESS_SAVE,HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>(ErrorApi.SCH_ERROR_EMPTY, HttpStatus.BAD_REQUEST);
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
