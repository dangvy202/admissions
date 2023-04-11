package com.sch.mgmt.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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

}
