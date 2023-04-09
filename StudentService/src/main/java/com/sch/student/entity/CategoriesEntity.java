package com.sch.student.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
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
    @JsonUnwrapped
    private int id;

    @Column(name = "name_subject")
    @JsonUnwrapped
    private String nameSubject;

    @Column(name = "create_category")
    @JsonUnwrapped
    private Date createCategory;

    @Column(name = "modify_category")
    @JsonUnwrapped
    private Date modifyCategory;

}
