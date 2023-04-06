package com.sch.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "sch_account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String passWord;

    @Column(name = "status")
    private int status;

    @Column(name = "verify")
    private String verify;

    @Column(name = "identifier_code")
    private String identifierCode;

    @Column(name = "enable")
    private int enable;

    @Column(name = "role")
    private String role;

    @Column(name = "create_account")
    private Date createAccount;

    @Column(name = "modify_account")
    private Date modifyAccount;

}
