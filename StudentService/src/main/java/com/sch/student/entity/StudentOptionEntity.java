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

    @Column(name = "math_cs1")
    @JsonUnwrapped
    private int mathCS1;

    @Column(name = "literature_cs1")
    @JsonUnwrapped
    private String literatureCS1;

    @Column(name = "informatics_cs1")
    @JsonUnwrapped
    private String informaticsCS1;

    @Column(name = "physics_cs1")
    @JsonUnwrapped
    private String physicsCS1;

    @Column(name = "chemistry_cs1")
    @JsonUnwrapped
    private String chemistryCS1;

    @Column(name = "biology_cs1")
    @JsonUnwrapped
    private String biologycs1;

    @Column(name = "english_cs1")
    @JsonUnwrapped
    private String englishCS1;

    @Column(name = "math_cs2")
    @JsonUnwrapped
    private int mathCS2;

    @Column(name = "literature_cs2")
    @JsonUnwrapped
    private String literatureCS2;

    @Column(name = "informatics_cs2")
    @JsonUnwrapped
    private String informaticsCS2;

    @Column(name = "physics_cs2")
    @JsonUnwrapped
    private String physicsCS2;

    @Column(name = "chemistry_cs2")
    @JsonUnwrapped
    private String chemistryCS2;

    @Column(name = "biology_cs2")
    @JsonUnwrapped
    private String biologycs2;

    @Column(name = "english_cs2")
    @JsonUnwrapped
    private String englishCS2;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_report" , nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JsonUnwrapped
    private StudentReportEntity studentReport;

    @Column(name = "create_option")
    @JsonUnwrapped
    private Date createOption;

    @Column(name = "modify_option")
    @JsonUnwrapped
    private Date modifyOption;
}
