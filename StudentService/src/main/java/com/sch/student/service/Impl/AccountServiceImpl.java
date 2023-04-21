package com.sch.student.service.Impl;

import com.sch.student.configuration.TokenVerifyAccount;
import com.sch.student.constant.ErrorApi;
import com.sch.student.constant.SuccessApi;
import com.sch.student.dto.AccountDTO;
import com.sch.student.entity.AccountEntity;
import com.sch.student.pojo.Account;
import com.sch.student.pojo.Student;
import com.sch.student.repository.AccountRepository;
import com.sch.student.service.AccountService;
import jakarta.annotation.Nullable;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JavaMailSender mailSender;

    public AccountEntity findAccountByIdentifierCode(String id){
        return accountRepository.checkIdentifierCodeAccount(id);
    }


    @Override
    public Optional<AccountEntity> findAccountById(Long id){
        return accountRepository.findById(id);
    }

    @Override
    public AccountEntity setAccountForApplicationForm(String identifierCode){
        AccountEntity accountForApplicationForm = accountRepository.checkIdentifierCodeAccount(identifierCode);
        return accountForApplicationForm;
    }

    @Override
    public void registerAccount(AccountEntity account){
        accountRepository.save(account);
    }

    @Override
    //CHECK IF BOOLEAN == TRUE USE ACCOUNT TYPE , IF BOOLEAN == FALSE ACCOUNT ENTITY
    public AccountEntity setAccountRequest(@Nullable Account account,@Nullable AccountDTO accountDTO){
        //Encode password
        PasswordEncoder encrypted = new BCryptPasswordEncoder();

        //date now
        long millis=System.currentTimeMillis();
        Date dateNow = new Date(millis);

        AccountEntity accountRegister = new AccountEntity();
        if(account != null){
            //set token verify
            TokenVerifyAccount tokenVerifyAccount = new TokenVerifyAccount();
            String tokenInsert =  tokenVerifyAccount.randomTokenVerify();

            //check identifier code
            AccountEntity checkIdentifierCode = accountRepository.checkIdentifierCodeAccount(account.getAccount().getIdentifierCode());

            //check verify
            AccountEntity checkVerify = accountRepository.checkVerifyAccount(tokenInsert);

            if(!tokenInsert.isEmpty() && checkIdentifierCode == null && checkVerify == null){
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
                return null;
            }
        }else if(accountDTO != null){
            //set account dto
            accountRegister = AccountEntity.builder()
                    .email(accountDTO.getEmail())
                    .passWord(encrypted.encode(accountDTO.getPassword()))
                    .identifierCode(accountDTO.getIdentifierCode())
                    .createAccount(dateNow)
                    .modifyAccount(dateNow)
                    .build();
            return accountRegister;
        }else {
            return null;
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
            System.getProperties();
            return SuccessApi.VERIFY_STATUS_SUCCESS;
        }else {
            return ErrorApi.VERIFY_STATUS_FAIL;
        }
    }

    public void sendMailVerifyAccount(String newHTML,String subject,String senderName,String contentMail,AccountEntity account,String url,String type) throws MessagingException, UnsupportedEncodingException {
        if(!url.isEmpty()){
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
        }else if(type == "FORGOT"){
            contentMail += "<h3>Reset Password</h3>";

            contentMail += "<p>Forgot your password?\n" +
                    "Temporary Password for Shinhan Vietnam Bank InternetBanking Password Reset was forwarded.</p>";

            contentMail += newHTML;

            contentMail += "<p>Thanks you.</p>";

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom(account.getEmail(),senderName);
            helper.setTo(account.getEmail());
            helper.setSubject(subject);
            helper.setText(contentMail,true);

            mailSender.send(message);
        }else{
            contentMail += "<p>BẠN ĐÃ ĐĂNG KÝ XÉT TUYỂN THÀNH CÔNG</p>";

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
}
