package com.sch.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "sch_application_form")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApplicationFormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_application")
    @JsonUnwrapped
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user" , nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JsonUnwrapped
    private StudentEntity schUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_report" , nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JsonUnwrapped
    private StudentReportEntity schReport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_option" , nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JsonUnwrapped
    private StudentOptionEntity schOption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_class" , nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JsonUnwrapped
    private StudentInfoClassEntity schInfoClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_enroll" , nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JsonUnwrapped
    private StudentEnrollEntity schEnroll;

    @Column(name = "create_application")
    @JsonUnwrapped
    private Date createApplication;

    @Column(name = "modify_application")
    @JsonUnwrapped
    private Date modifyApplication;
}
