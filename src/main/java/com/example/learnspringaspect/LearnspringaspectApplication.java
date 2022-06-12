package com.example.learnspringaspect;

import com.example.learnspringaspect.aspect.Config;
import com.example.learnspringaspect.dao.AccountDAO;
import com.example.learnspringaspect.dao.MembershipDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LearnspringaspectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnspringaspectApplication.class, args);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		accountDao.addSillyAccount();
		accountDao.addAgain();
		membershipDAO.addMemberAccount(new Account("name"));

		accountDao.addSillyAccount(new Account("name"), "=Jake");

		context.close();

	}

}
