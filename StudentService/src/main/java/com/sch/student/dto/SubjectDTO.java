package com.sch.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDTO {

    @JsonProperty("math")
    private int math;

    @JsonProperty("literature")
    private int literature;

    @JsonProperty("informatics")
    private int informatics;

    @JsonProperty("physics")
    private int physics;

    @JsonProperty("chemistry")
    private int chemistry;

    @JsonProperty("biology")
    private int biology;

    @JsonProperty("english")
    private int english;
}
