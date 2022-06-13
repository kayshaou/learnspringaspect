package com.example.learnspringaspect;

import com.example.learnspringaspect.aspect.Config;
import com.example.learnspringaspect.dao.AccountDAO;
import com.example.learnspringaspect.dao.MembershipDAO;
import com.example.learnspringaspect.service.TrafficFortuneService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class LearnspringaspectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnspringaspectApplication.class, args);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		log.info("this won't throw ex fortune: {}", theFortuneService.getFortune());

		// this will throw
		theFortuneService.getFortune(true);


		//		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);
//
//		String joined = accountDao.findAccounts().stream().map(a ->
//				{
//					return a.getServiceCode() + " " + a.getName();
//				})
//				.collect(Collectors.joining(","));
//
//		try {
//			accountDao.thisthrowexception();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		log.info("joined {}", joined);
//		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
//		accountDao.addSillyAccount();
//		accountDao.addAgain();
//
//		accountDao.setAccountName("acc-name");
//		accountDao.setName("name");
//
//		String n = accountDao.getAccountName();
//		String nn = accountDao.getName();
//
//		membershipDAO.addMemberAccount(new Account("name", "RTG-4005"));
//
//		accountDao.addSillyAccount(new Account("name", "RTG-4004"), "=Jake");

		context.close();

	}

}
