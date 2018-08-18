package com.revature.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.daos.UserDao;

public class LoginScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;
	private Logger log = Logger.getRootLogger();

	public Screen start() {
		System.out.println("priate");
		log.debug("started login screen");
		System.out.println("Enter Username or type Register to sign up: ");
		System.out.println("hello");
		String username = scan.nextLine();
		log.trace("username = " + username);
		if ("register".equalsIgnoreCase(username)) {
			return new RegisterUserScreen();
		}
		
		System.out.println("Enter Password: ");
		String password = scan.nextLine();
		
		if(username.matches("0") && password.matches("0") == true) {
			//return new CaptainScreen();
			
		}
		
		log.debug("received users credentials");
		User currentUser = ud.findByUsernameAndPassword(username, password);
		if (currentUser != null) {
			log.info("user succefully logged in");
			return new TransactionScreen(currentUser);
		}

		System.out.println("unable to login");
		return this;
	}

}
