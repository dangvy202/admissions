package com.sch.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentOptionDTO {


    @JsonProperty("math")
    private int math;

    @JsonProperty("informaticsInformatics")
    private int informaticsInformatics;

    @JsonProperty("informaticsMath")
    private int informaticsMath;

    @JsonProperty("physicsPhysics")
    private int physicsPhysics;


    @JsonProperty("physicsMath")
    private int physicsMath;

    @JsonProperty("chemistry")
    private int chemistry;

    @JsonProperty("biology")
    private int biology;

    @JsonProperty("english")
    private int english;

    @JsonProperty("literature")
    private int literature;

    @JsonProperty("mathLN")
    private int mathLN;

    @JsonProperty("physicsPhysicsLN")
    private int physicsPhysicsLN;

    @JsonProperty("physicsMathLN")
    private int physicsMathLN;

    @JsonProperty("chemistryChemistryLN")
    private int chemistryChemistryLN;

    @JsonProperty("chemistryMathLN")
    private int chemistryMathLN;

    @JsonProperty("biologyBiologyLN")
    private int biologyBiologyLN;

    @JsonProperty("biologyMathLN")
    private int biologyMathLN;

    @JsonProperty("englishLN")
    private int englishLN;

    @JsonProperty("literatureLN")
    private int literatureLN;


}
