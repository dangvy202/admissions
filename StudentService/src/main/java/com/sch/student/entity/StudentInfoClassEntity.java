package com.sch.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "sch_info_class")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentInfoClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_class")
    private Long id;

    @Column(name = "6th_grade")
    private int grade6TH;

    @Column(name = "7th_grade")
    private int grade7TH;

    @Column(name = "8th_grade")
    private int grade8TH;

    @Column(name = "9th_grade")
    private int grade9TH;

    @Column(name = "conduct_certificate")
    private int conductCertificate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_report" , nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private StudentReportEntity studentReport;

    @Column(name = "create_info_class")
    private Date createInfoClass;

    @Column(name = "modify_info_class")
    private Date modifyInfoClass;
}
