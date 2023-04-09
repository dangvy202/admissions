package com.sch.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
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
    @JsonUnwrapped
    private Long id;

    @Column(name = "email")
    @JsonUnwrapped
    private String email;

    @Column(name = "password")
    @JsonUnwrapped
    private String passWord;

    @Column(name = "status")
    @JsonUnwrapped
    private int status;

    @Column(name = "verify")
    @JsonUnwrapped
    private String verify;

    @Column(name = "identifier_code")
    @JsonUnwrapped
    private String identifierCode;

    @Column(name = "enable")
    @JsonUnwrapped
    private int enable;

    @Column(name = "role")
    @JsonUnwrapped
    private String role;

    @Column(name = "create_account")
    @JsonUnwrapped
    private Date createAccount;

    @Column(name = "modify_account")
    @JsonUnwrapped
    private Date modifyAccount;

}
