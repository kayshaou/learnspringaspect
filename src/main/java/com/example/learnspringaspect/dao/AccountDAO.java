package com.example.learnspringaspect.dao;

import com.example.learnspringaspect.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component(value = "accountDAO")
@Slf4j
public class AccountDAO {

    public void thisthrowexception() {
        throw new RuntimeException(" this gets throwns ");
    }
    public List<Account> findAccounts()
    {
        Account acc = new Account("John1", "silver1");
        Account acc2 = new Account("John2", "siler2");
        Account acc3 = new Account("John3", "siler3");

        List<Account> accountList = Arrays.asList(acc, acc2, acc3);
        return accountList;
    }
    private String name;

    public String getName() {
        log.info("get "+name);
        return name;
    }

    public void setName(String name) {
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
