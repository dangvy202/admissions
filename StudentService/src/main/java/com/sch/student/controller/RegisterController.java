package com.sch.student.controller;

import com.sch.student.entity.AccountEntity;
import com.sch.student.pojo.Account;
import com.sch.student.pojo.Student;
import com.sch.student.service.Impl.AccountServiceImpl;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

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
            accountServiceImpl.registerAccount(account);
            String url = request.getRequestURL().toString();
            accountServiceImpl.sendMailVerifyAccount(account,url.replace(request.getServletPath(), ""));
        }
        return null;
    }
    @PostMapping("/verify")
    public String verifyAccount(){
        return null;
    }
}
