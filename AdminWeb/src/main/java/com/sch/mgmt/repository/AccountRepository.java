package com.sch.mgmt.repository;

import com.sch.mgmt.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {
    @Query("SELECT a FROM AccountEntity a WHERE a.verify = :verify")
    AccountEntity checkVerifyAccount(String verify);

    @Query("SELECT a FROM AccountEntity a WHERE a.identifierCode = :iden")
    AccountEntity checkIdentifierCodeAccount(String iden);

    @Query("SELECT a FROM AccountEntity a WHERE a.email = :email")
    AccountEntity checkEmail(String email);
}
