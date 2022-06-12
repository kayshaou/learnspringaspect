package com.example.learnspringaspect.dao;

import com.example.learnspringaspect.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component(value = "accountDAO")
@Slf4j
public class AccountDAO {

    private String name;

    public String getName() {
        log.info("get "+name);
        return name;
    }

    public void setName(String name) {
        log.info("set "+getName());
        this.name = name;
    }

    public String getAccountName() {
        log.info("get "+accountName);
        return accountName;
    }

    public void setAccountName(String accountName) {
        log.info("set "+accountName);
        this.accountName = accountName;
    }

    private String accountName;

    public int addSillyAccount() {
        log.info(getClass()+" "+"doing the db work");
        return -1;
    }

    public Account addSillyAccount(Account acc, String test) {
        log.info(getClass()+" "+"doing the Account db work");
        return acc;
    }

    public boolean addAgain() {
        log.info(getClass()+" "+"doing the addAgain db work");
        return true;
    }
}
