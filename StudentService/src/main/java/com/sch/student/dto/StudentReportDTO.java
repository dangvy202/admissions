package com.sch.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentReportDTO {
    @JsonProperty("schoolPassed")
    private String schoolPassed;

    @JsonProperty("nameClass")
    private String nameClass;

    @JsonProperty("ward")
    private String ward;

    @JsonProperty("province")
    private String province;

    @JsonProperty("district")
    private String district;

    @JsonProperty("schoolAddress")
    private String schoolAddress;

    @JsonProperty("academicAbility")
    private int academicAbility;

}
