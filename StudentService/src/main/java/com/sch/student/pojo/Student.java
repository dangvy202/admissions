package com.sch.student.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sch.student.dto.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student{
    @JsonProperty("UserInfo")
    private StudentDTO userInfo;

    @JsonProperty("UserReport")
    private StudentReportDTO userReport;

    @JsonProperty("UserClassPassed")
    private StudentInfoClassDTO userInfoClass;

    @JsonProperty("UserEnroll")
    private StudentEnrollDTO userEnroll;

    @JsonProperty("UserOption")
    private StudentOptionDTO userOption;

    @JsonProperty("Account")
    private AccountDTO account;

    @JsonProperty("Subject")
    private SubjectDTO subject;

    @JsonProperty("ImgUser")
    private ImgDTO img;

}
