package com.sch.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentDTO {
    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;

    @JsonProperty("address")
    private String address;

    @JsonProperty("birthday")
    private Date birthday;

    @JsonProperty("sex")
    private int sex;

    @JsonProperty("ethnicity")
    private String ethnicity;

    @JsonProperty("identifyInfo")
    private String identifyInfo;

    @JsonProperty("nationality")
    private String nationality;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("landlinePhoneNumber")
    private String landlinePhoneNumber;

    @JsonProperty("optionPhone")
    private String optionPhone;

}
