package com.sch.student.repository;

import com.sch.student.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {
    @Query("SELECT a FROM AccountEntity a WHERE a.verify = :verify")
    AccountEntity checkVerifyAccount(String verify);

    @Query("SELECT a FROM AccountEntity a WHERE a.identifierCode = :identifierCode")
    AccountEntity checkIdentifierCodeAccount(String identifierCode);

    @Query("SELECT a FROM AccountEntity a WHERE a.email = :email")
    AccountEntity checkEmail(String email);
}
