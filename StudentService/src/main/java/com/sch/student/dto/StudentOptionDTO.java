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

    @JsonProperty("informatics_informatics")
    private int informaticsInformatics;

    @JsonProperty("informatics_math")
    private int informaticsMath;

    @JsonProperty("physic_physic")
    private int physicsPhysics;


    @JsonProperty("physic_math")
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

    @JsonProperty("physic_physic_LN")
    private int physicsPhysicsLN;

    @JsonProperty("physic_math_LN")
    private int physicsMathLN;

    @JsonProperty("chemistry_chemistry_LN")
    private int chemistryChemistryLN;

    @JsonProperty("chemistry_math_LN")
    private int chemistryMathLN;

    @JsonProperty("biology_biology_LN")
    private int biologyBiologyLN;

    @JsonProperty("biology_math_LN")
    private int biologyMathLN;

    @JsonProperty("englishLN")
    private int englishLN;

    @JsonProperty("literatureLN")
    private int literatureLN;


//    @JsonProperty("math")
//    private int math;
//
//    @JsonProperty("informaticsInformatics")
//    private int informaticsInformatics;
//
//    @JsonProperty("informaticsMath")
//    private int informaticsMath;
//
//    @JsonProperty("physicsPhysics")
//    private int physicsPhysics;
//
//
//    @JsonProperty("physicsMath")
//    private int physicsMath;
//
//    @JsonProperty("chemistry")
//    private int chemistry;
//
//    @JsonProperty("biology")
//    private int biology;
//
//    @JsonProperty("english")
//    private int english;
//
//    @JsonProperty("literature")
//    private int literature;
//
//    @JsonProperty("mathLN")
//    private int mathLN;
//
//    @JsonProperty("physicsPhysicsLN")
//    private int physicsPhysicsLN;
//
//    @JsonProperty("physicsMathLN")
//    private int physicsMathLN;
//
//    @JsonProperty("chemistryChemistryLN")
//    private int chemistryChemistryLN;
//
//    @JsonProperty("chemistryMathLN")
//    private int chemistryMathLN;
//
//    @JsonProperty("biologyBiologyLN")
//    private int biologyBiologyLN;
//
//    @JsonProperty("biologyMathLN")
//    private int biologyMathLN;
//
//    @JsonProperty("englishLN")
//    private int englishLN;
//
//    @JsonProperty("literatureLN")
//    private int literatureLN;


}
