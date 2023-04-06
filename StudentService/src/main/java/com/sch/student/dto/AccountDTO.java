package com.sch.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {

    @JsonProperty("email")
    private String email;

    @JsonProperty("passWord")
    private String password;

    @JsonProperty("identifierCode")
    private String identifierCode;

}
