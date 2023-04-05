package com.sch.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private Long id;

    @Column(name = "other_subject_1th")
    private String otherSubject1th;

    @Column(name = "other_subject_2th")
    private String otherSubject2th;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_report" , nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private StudentReportEntity studentReport;

    @Column(name = "create_enroll")
    private Date createEnroll;

    @Column(name = "modify_enroll")
    private Date modifyEnroll;

}
