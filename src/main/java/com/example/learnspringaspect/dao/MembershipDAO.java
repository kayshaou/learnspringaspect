package com.example.learnspringaspect.dao;

import com.example.learnspringaspect.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MembershipDAO {

    public void addAccount() {
        log.info(getClass()+" "+"doing the db work");
    }

    public Account addMemberAccount(Account acc) {
        log.info(getClass()+" "+"doing the db work");
        return acc;
    }
}
