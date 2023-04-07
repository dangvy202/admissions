package com.sch.student.service.Impl;

import com.sch.student.configuration.TokenVerifyAccount;
import com.sch.student.constant.ErrorApi;
import com.sch.student.constant.SuccessApi;
import com.sch.student.entity.AccountEntity;
import com.sch.student.pojo.Account;
import com.sch.student.pojo.Student;
import com.sch.student.repository.AccountRepository;
import com.sch.student.service.AccountService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void registerAccount(AccountEntity account){
        accountRepository.save(account);
    }

    @Override
    public AccountEntity setAccountRequest(Account account){
        //Encode password
        PasswordEncoder encrypted = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        //date now
        long millis=System.currentTimeMillis();
        Date dateNow = new Date(millis);

        //set token verify
        TokenVerifyAccount tokenVerifyAccount = new TokenVerifyAccount();
        String tokenInsert =  tokenVerifyAccount.randomTokenVerify();

        //check identifier code
        AccountEntity checkIdentifierCode = accountRepository.checkIdentifierCodeAccount(account.getAccount().getIdentifierCode());

        //check verify
        AccountEntity checkVerify = accountRepository.checkVerifyAccount(tokenInsert);

        //check email
        AccountEntity checkEmail = accountRepository.checkEmail(account.getAccount().getEmail());

        AccountEntity accountRegister = new AccountEntity();
        if(!tokenInsert.isEmpty() && checkIdentifierCode == null && checkVerify == null && checkEmail == null){
            accountRegister = AccountEntity.builder()
                    .email(account.getAccount().getEmail())
                    .passWord(encrypted.encode(account.getAccount().getPassword()))
                    .status(0)
                    .verify(tokenInsert)
                    .identifierCode(account.getAccount().getIdentifierCode())
                    .enable(0)
                    .role("USER")
                    .createAccount(dateNow)
                    .modifyAccount(dateNow)
                    .build();
            return accountRegister;
        }else {
            return accountRegister;
        }
    }

    @Override
    public String verifyAccountRequest(String verifyCode){
        AccountEntity getDetailAccountInfo = accountRepository.checkVerifyAccount(verifyCode);
        if(getDetailAccountInfo != null){
            //Update status , enable
            getDetailAccountInfo.setStatus(1);
            getDetailAccountInfo.setEnable(1);
            registerAccount(getDetailAccountInfo);
            return SuccessApi.VERIFY_STATUS_SUCCESS;
        }else {
            return ErrorApi.VERIFY_STATUS_FAIL;
        }
    }

    public void sendMailVerifyAccount(AccountEntity account,String url) throws MessagingException, UnsupportedEncodingException {
        String subject = "Please verify your registration";
        String senderName="Net Movie";
        String contentMail = "<p>Dear " + account.getEmail()+",</p>";
        contentMail += "<p>Please click the link below to verify to you registration</p>";

        //get url verification
        String verifyURL = url + "/account/register/verify?code=" + account.getVerify();
        //end

        contentMail += "<h3> <a href=\"" + verifyURL + "\">VERIFY ACCOUNT</a></h3>";

        contentMail += "<p>Thanks you.</p>";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(account.getEmail(),senderName);
        helper.setTo(account.getEmail());
        helper.setSubject(subject);
        helper.setText(contentMail,true);

        mailSender.send(message);
    }
}
