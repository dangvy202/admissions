package com.sch.student.controller;

import com.sch.student.constant.ErrorApi;
import com.sch.student.constant.SuccessApi;
import com.sch.student.entity.AccountEntity;
import com.sch.student.pojo.Account;
import com.sch.student.repository.AccountRepository;
import com.sch.student.security.JwtTokenProvider;
import com.sch.student.service.Impl.AccountServiceImpl;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/account")
public class RegisterController {

    private AccountServiceImpl accountServiceImpl;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final AccountRepository users;

    public RegisterController(AccountServiceImpl accountServiceImpl, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, AccountRepository users){
        this.accountServiceImpl = accountServiceImpl;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.users = users;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Account data) {
//        accountServiceImpl.
//check verify
        try {
            String username = data.getAccount().getIdentifierCode();
            var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getAccount().getPassword()));
            String token = jwtTokenProvider.createToken(authentication);
            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerAccount(@RequestBody Account requestRegister, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        AccountEntity account = accountServiceImpl.setAccountRequest(requestRegister,null);
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
