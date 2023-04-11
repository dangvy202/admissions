package com.sch.mgmt.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "sch_subject")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subject")
    private Long id;

    @Column(name = "math")
    private int math;

    @Column(name = "literature")
    private int literature;

    @Column(name = "informatics")
    private int informatics;

    @Column(name = "physics")
    private int physics;

    @Column(name = "chemistry")
    private int chemistry;

    @Column(name = "biology")
    private int biology;

    @Column(name = "english")
    private int english;
}
