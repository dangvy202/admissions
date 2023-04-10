package com.sch.student.service;

import com.sch.student.entity.AccountEntity;
import com.sch.student.pojo.Account;
import com.sch.student.pojo.Student;
import org.springframework.stereotype.Service;


@Service
public interface AccountService {
    void registerAccount(AccountEntity account);
    AccountEntity setAccountRequest(Account account);
    String verifyAccountRequest(String identifierCode);
}
