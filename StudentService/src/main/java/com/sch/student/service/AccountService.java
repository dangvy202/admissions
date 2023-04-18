package com.sch.student.service;

import com.sch.student.dto.AccountDTO;
import com.sch.student.entity.AccountEntity;
import com.sch.student.pojo.Account;
import com.sch.student.pojo.Student;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface AccountService {
    void registerAccount(AccountEntity account);
    AccountEntity setAccountRequest(Account account, AccountDTO accountDTO);
    String verifyAccountRequest(String identifierCode);
    Optional<AccountEntity> findAccountById(Long id);
    AccountEntity setAccountForApplicationForm(String identifierCode);
}
