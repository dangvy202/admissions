package com.sch.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "sch_student_report")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_report")
    private Long id;

    @Column(name = "school_passed")
    private String schoolPassed;

    @Column(name = "school_address")
    private String schoolAddress;

    @Column(name = "academic_ability")
    private int academicAbility;

//    @Column(name = "id_user")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user" , nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private StudentEntity student;

    @Column(name = "create_report")
    private Date createReport;

    @Column(name = "modify_report")
    private Date modifyReport;
}
