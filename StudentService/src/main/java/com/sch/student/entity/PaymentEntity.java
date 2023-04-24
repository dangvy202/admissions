package com.sch.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "sch_payment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Long id;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "status")
    private int status;

    @Column(name = "create_payment")
    private Date createPayment;

    @Column(name = "modify_payment")
    private Date modifyPayment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_account" , nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JsonUnwrapped
    private AccountEntity schAccount;
}
