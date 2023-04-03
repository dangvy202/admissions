package com.sch.student.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "sch_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "verify")
    private int verify;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "sex")
    private int sex;

    @Column(name = "ethnicity")
    private String ethnicity;

    @Column(name = "identify_info")
    private String identifyInfo;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "landline_phone_number")
    private String landlinePhoneNumber;

    @Column(name = "option_phone")
    private String optionPhone;

    @Column(name = "create_account")
    private Date createAccount;

    @Column(name = "modify_account")
    private Date modifyAccount;
}
