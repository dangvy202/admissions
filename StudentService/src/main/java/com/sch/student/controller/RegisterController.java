package com.sch.student.controller;

import com.sch.student.constant.ErrorApi;
import com.sch.student.constant.SuccessApi;
import com.sch.student.entity.AccountEntity;
import com.sch.student.pojo.Account;
import com.sch.student.pojo.Student;
import com.sch.student.repository.AccountRepository;
import com.sch.student.service.Impl.AccountServiceImpl;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/account")
public class RegisterController {

    private AccountServiceImpl accountServiceImpl;

    public RegisterController(AccountServiceImpl accountServiceImpl){
        this.accountServiceImpl = accountServiceImpl;
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerAccount(@RequestBody Account requestRegister, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        AccountEntity account = accountServiceImpl.setAccountRequest(requestRegister);
        if(account != null){
            String url = request.getRequestURL().toString();
            accountServiceImpl.sendMailVerifyAccount("Please verify your registration","TRƯỜNG THPT NĂNG KHIẾU","<p>Dear "+account.getEmail()+",</p>",account,url.replace(request.getServletPath(), ""));
            accountServiceImpl.registerAccount(account);
            return new ResponseEntity<>(SuccessApi.REGISTER_SUCCESS,HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(ErrorApi.EMAIL_ID_EXIST,HttpStatus.EXPECTATION_FAILED);
    }
    @PostMapping("/register/verify")
    public ResponseEntity<String> verifyAccount(@RequestParam("code") String code){
        if(!code.isEmpty()){
            if(accountServiceImpl.verifyAccountRequest(code) == ErrorApi.VERIFY_STATUS_FAIL){
                return new ResponseEntity<>(ErrorApi.VERIFY_CODE_STATUS_FAIL,HttpStatus.BAD_REQUEST);
            }else{
                accountServiceImpl.verifyAccountRequest(code);
                return new ResponseEntity<>(SuccessApi.VERIFY_STATUS_SUCCESS, HttpStatus.OK);
            }
        }
        else {
            return new ResponseEntity<>(ErrorApi.VERIFY_STATUS_FAIL,HttpStatus.BAD_REQUEST);
        }
    }
}
