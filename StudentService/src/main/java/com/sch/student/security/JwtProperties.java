package com.sch.student.security;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class JwtProperties {
//    @Value("${app.jwtSecret}")
    private String secret = "rzxlszyykpbgqcflzxsqcysyhljt";

    @Value("${app.jwtExpirationInMs}")
    private Long validityInMs;
}
