package com.sch.student.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
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
    @JsonUnwrapped
    private Long id;

    @Column(name = "first_name")
    @JsonUnwrapped
    private String firstName;

    @Column(name = "last_name")
    @JsonUnwrapped
    private String lastName;

    @Column(name = "place_of_birth")
    @JsonUnwrapped
    private String placeOfBirth;

    @Column(name = "province")
    @JsonUnwrapped
    private String province;

    @Column(name = "district")
    @JsonUnwrapped
    private String district;

    @Column(name = "ward")
    @JsonUnwrapped
    private String ward;

    @Column(name = "address")
    @JsonUnwrapped
    private String address;

    @Column(name = "birthday")
    @JsonUnwrapped
    private Date birthday;

    @Column(name = "sex")
    @JsonUnwrapped
    private int sex;

    @Column(name = "ethnicity")
    @JsonUnwrapped
    private String ethnicity;

    @Column(name = "identify_info")
    @JsonUnwrapped
    private String identifyInfo;

    @Column(name = "nationality")
    @JsonUnwrapped
    private String nationality;

    @Column(name = "phone_number")
    @JsonUnwrapped
    private String phoneNumber;

    @Column(name = "landline_phone_number")
    @JsonUnwrapped
    private String landlinePhoneNumber;

    @Column(name = "option_phone")
    @JsonUnwrapped
    private String optionPhone;

    @Column(name = "create_account")
    @JsonUnwrapped
    private Date createAccount;

    @Column(name = "modify_account")
    @JsonUnwrapped
    private Date modifyAccount;
}
