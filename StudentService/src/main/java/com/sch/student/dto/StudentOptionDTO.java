package com.sch.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentOptionDTO {

    @JsonProperty("mathCS1")
    private int mathCS1;

    @JsonProperty("literatureCS1")
    private String literatureCS1;

    @JsonProperty("informaticsCS1")
    private String informaticsCS1;

    @JsonProperty("physicsCS1")
    private String physicsCS1;

    @JsonProperty("chemistryCS1")
    private String chemistryCS1;

    @JsonProperty("biologycs1")
    private String biologycs1;

    @JsonProperty("englishCS1")
    private String englishCS1;

    @JsonProperty("mathCS2")
    private int mathCS2;

    @JsonProperty("literatureCS2")
    private String literatureCS2;

    @JsonProperty("informaticsCS2")
    private String informaticsCS2;

    @JsonProperty("physicsCS2")
    private String physicsCS2;

    @JsonProperty("chemistryCS2")
    private String chemistryCS2;

    @JsonProperty("biologycs2")
    private String biologycs2;

    @JsonProperty("englishCS2")
    private String englishCS2;

}
