package com.sch.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
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
    @JsonUnwrapped
    private Long id;

    @Column(name = "school_passed")
    @JsonUnwrapped
    private String schoolPassed;

    @Column(name = "name_class")
    @JsonUnwrapped
    private String nameClass;

    @Column(name = "ward")
    @JsonUnwrapped
    private String ward;

    @Column(name = "province")
    @JsonUnwrapped
    private String province;

    @Column(name = "district")
    @JsonUnwrapped
    private String district;

    @Column(name = "school_address")
    @JsonUnwrapped
    private String schoolAddress;

    @Column(name = "academic_ability")
    @JsonUnwrapped
    private int academicAbility;

//    @Column(name = "id_user")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user" , nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JsonUnwrapped
    private StudentEntity student;

    @Column(name = "create_report")
    @JsonUnwrapped
    private Date createReport;

    @Column(name = "modify_report")
    @JsonUnwrapped
    private Date modifyReport;

    public void update(StudentReportEntity studentReport){
        setSchoolPassed(studentReport.getSchoolPassed());
        setNameClass(studentReport.getNameClass());
        setProvince(studentReport.getProvince());
        setDistrict(studentReport.getDistrict());
        setWard(studentReport.getWard());
        setSchoolAddress(studentReport.getSchoolAddress());
        setAcademicAbility(studentReport.getAcademicAbility());
        setStudent(studentReport.getStudent());
        setCreateReport(studentReport.getCreateReport());
        setModifyReport(studentReport.getModifyReport());
    }
}
