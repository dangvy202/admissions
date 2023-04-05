package com.sch.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
public class StudentEnrollDTO {
    @JsonProperty("otherSubject1th")
    private ArrayList<String> otherSubject1th;

    @JsonProperty("otherSubject2th")
    private ArrayList<String> otherSubject2th;

}
