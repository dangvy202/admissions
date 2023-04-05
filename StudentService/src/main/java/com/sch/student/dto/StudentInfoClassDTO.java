package com.sch.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentInfoClassDTO {
    @JsonProperty("grade6TH")
    private int grade6TH;

    @JsonProperty("grade7TH")
    private int grade7TH;

    @JsonProperty("grade8TH")
    private int grade8TH;

    @JsonProperty("grade9TH")
    private int grade9TH;

    @JsonProperty("conductCertificate")
    private int conductCertificate;
}
