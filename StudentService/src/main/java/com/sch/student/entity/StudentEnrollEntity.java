package com.sch.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "sch_enroll_student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentEnrollEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enroll")
    @JsonUnwrapped
    private Long id;

    @Column(name = "other_subject_1th")
    @JsonUnwrapped
    private String otherSubject1th;

    @Column(name = "other_subject_2th")
    @JsonUnwrapped
    private String otherSubject2th;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_report" , nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JsonUnwrapped
    private StudentReportEntity studentReport;

    @Column(name = "create_enroll")
    @JsonUnwrapped
    private Date createEnroll;

    @Column(name = "modify_enroll")
    @JsonUnwrapped
    private Date modifyEnroll;

    public void update(StudentEnrollEntity enrollUpdate){
        if(enrollUpdate.getStudentReport() != null){

        }
        if(enrollUpdate.getCreateEnroll() != null){
            setCreateEnroll(enrollUpdate.getCreateEnroll());
        }
        if(enrollUpdate.getModifyEnroll() != null){
            setModifyEnroll(enrollUpdate.getModifyEnroll());
        }
        if(enrollUpdate.getOtherSubject2th() != null){
            setOtherSubject2th(enrollUpdate.getOtherSubject2th());
        }
        if(enrollUpdate.getOtherSubject1th() != null){
            setOtherSubject1th(enrollUpdate.getOtherSubject1th());
        }
    }
}
