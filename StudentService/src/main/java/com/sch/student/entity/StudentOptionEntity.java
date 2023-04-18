package com.sch.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "sch_option_student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentOptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_option")
    @JsonUnwrapped
    private Long id;

    @Column(name = "math")
    @JsonUnwrapped
    private int math;

    @Column(name = "informatics_informatics")
    @JsonUnwrapped
    private int informaticsInformatics;

    @Column(name = "informatics_math")
    @JsonUnwrapped
    private int informaticsMath;

    @Column(name = "physics_physics")
    @JsonUnwrapped
    private int physicsPhysics;


    @Column(name = "physics_math")
    @JsonUnwrapped
    private int physicsMath;

    @Column(name = "chemistry")
    @JsonUnwrapped
    private int chemistry;

    @Column(name = "biology")
    @JsonUnwrapped
    private int biology;

    @Column(name = "english")
    @JsonUnwrapped
    private int english;

    @Column(name = "literature")
    @JsonUnwrapped
    private int literature;

    @Column(name = "math_ln")
    @JsonUnwrapped
    private int mathLN;

    @Column(name = "physics_physics_ln")
    @JsonUnwrapped
    private int physicsPhysicsLN;

    @Column(name = "physics_math_ln")
    @JsonUnwrapped
    private int physicsMathLN;

    @Column(name = "chemistry_chemistry_ln")
    @JsonUnwrapped
    private int chemistryChemistryLN;

    @Column(name = "chemistry_math_ln")
    @JsonUnwrapped
    private int chemistryMathLN;

    @Column(name = "biology_biology_ln")
    @JsonUnwrapped
    private int biologyBiologyLN;


    @Column(name = "biology_math_ln")
    @JsonUnwrapped
    private int biologyMathLN;

    @Column(name = "english_ln")
    @JsonUnwrapped
    private int englishLN;

    @Column(name = "literature_ln")
    @JsonUnwrapped
    private int literatureLN;

    @Column(name = "create_option")
    @JsonUnwrapped
    private Date createOption;

    @Column(name = "modify_option")
    @JsonUnwrapped
    private Date modifyOption;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_report" , nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JsonUnwrapped
    private StudentReportEntity report;

    public void update(StudentOptionEntity studentOption){
        setBiology(studentOption.getBiology());
        setBiologyBiologyLN(studentOption.getBiologyBiologyLN());
        setBiologyMathLN(studentOption.getBiologyMathLN());
        setChemistry(studentOption.getChemistry());
        setChemistryChemistryLN(studentOption.getChemistryChemistryLN());
        setChemistryMathLN(studentOption.getChemistryMathLN());
        setEnglish(studentOption.getEnglish());
        setEnglishLN(studentOption.getEnglishLN());
        setInformaticsInformatics(studentOption.getInformaticsInformatics());
        setInformaticsMath(studentOption.getInformaticsMath());
        setLiterature(studentOption.getLiterature());
        setLiteratureLN(studentOption.getLiteratureLN());
        setMath(studentOption.getMath());
        setMathLN(studentOption.getMathLN());
        setPhysicsMath(studentOption.getPhysicsMath());
        setPhysicsMathLN(studentOption.getPhysicsMathLN());
        setPhysicsPhysics(studentOption.getPhysicsPhysics());
        setPhysicsPhysicsLN(studentOption.getPhysicsPhysicsLN());
    }
}
