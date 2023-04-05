package com.sch.student.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "category_subject")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CategoriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private int id;

    @Column(name = "name_subject")
    private String nameSubject;

    @Column(name = "create_category")
    private Date createCategory;

    @Column(name = "modify_category")
    private Date modifyCategory;

}
