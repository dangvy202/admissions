package com.sch.mgmt.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
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
    @JsonUnwrapped
    private Long id;

    @Column(name = "6th_grade")
    @JsonUnwrapped
    private int grade6TH;

    @Column(name = "7th_grade")
    @JsonUnwrapped
    private int grade7TH;

    @Column(name = "8th_grade")
    @JsonUnwrapped
    private int grade8TH;

    @Column(name = "9th_grade")
    @JsonUnwrapped
    private int grade9TH;

    @Column(name = "conduct_certificate_6th")
    @JsonUnwrapped
    private int conductCertificate6TH;

    @Column(name = "conduct_certificate_7th")
    @JsonUnwrapped
    private int conductCertificate7TH;

    @Column(name = "conduct_certificate_8th")
    @JsonUnwrapped
    private int conductCertificate8TH;

    @Column(name = "conduct_certificate_9th")
    @JsonUnwrapped
    private int conductCertificate9TH;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_report" , nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JsonUnwrapped
    private StudentReportEntity studentReport;

    @Column(name = "create_info_class")
    @JsonUnwrapped
    private Date createInfoClass;

    @Column(name = "modify_info_class")
    @JsonUnwrapped
    private Date modifyInfoClass;
}
