package com.sch.student.repository;

import com.sch.student.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity,Long> {
    @Query("SELECT p FROM PaymentEntity p WHERE p.schAccount.id = :identifier")
    PaymentEntity getAmmountByAccountIdentifier(Long identifier);
}
