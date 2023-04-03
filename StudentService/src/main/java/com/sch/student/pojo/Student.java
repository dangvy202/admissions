package com.sch.student.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sch.student.dto.StudentDTO;
import lombok.Getter;

@Getter
public class Student{
    @JsonProperty("UserInfo")
    private StudentDTO userInfo;
}
