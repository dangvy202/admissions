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

    @Column(name = "aspiration_1th")
    @JsonUnwrapped
    private String aspiration1th;

    @Column(name = "aspiration_2th")
    @JsonUnwrapped
    private String aspiration2th;

    @Column(name = "aspiration_3th")
    @JsonUnwrapped
    private String aspiration3th;

    @Column(name = "aspiration_4th")
    @JsonUnwrapped
    private String aspiration4th;

    @Column(name = "aspiration_5th")
    @JsonUnwrapped
    private String aspiration5th;

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
