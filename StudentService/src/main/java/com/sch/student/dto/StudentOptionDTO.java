package com.sch.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentOptionDTO {

    @JsonProperty("aspiration1th")
    private int aspiration1th;

    @JsonProperty("aspiration2th")
    private int aspiration2th;

    @JsonProperty("aspiration3th")
    private int aspiration3th;

    @JsonProperty("aspiration4th")
    private int aspiration4th;

    @JsonProperty("aspiration5th")
    private int aspiration5th;

}
