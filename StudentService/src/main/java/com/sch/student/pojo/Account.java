package com.sch.student.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sch.student.dto.AccountDTO;
import lombok.Getter;

@Getter
public class Account {

    @JsonProperty("Account")
    private AccountDTO account;
}
