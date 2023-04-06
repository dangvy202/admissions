package com.sch.student.configuration;

import com.sch.student.constant.ErrorApi;
import com.sch.student.constant.SuccessApi;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Configuration
public class TokenVerifyAccount {
    private String tokenVerifyForAccount;

    public String randomTokenVerify(){
        tokenVerifyForAccount = UUID.randomUUID().toString();
        return tokenVerifyForAccount;
    }
}
