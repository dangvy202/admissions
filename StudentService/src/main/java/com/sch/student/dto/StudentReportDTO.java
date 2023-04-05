package com.sch.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentReportDTO {
    @JsonProperty("schoolPassed")
    private String schoolPassed;

    @JsonProperty("schoolAddress")
    private String schoolAddress;

    @JsonProperty("academicAbility")
    private int academicAbility;

}
