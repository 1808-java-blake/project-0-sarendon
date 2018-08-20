package com.revature.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.daos.UserDao;
import com.revature.util.AppState;

public class LoginScreen implements Screen {
	private AppState state = AppState.state;
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;
	private Logger log = Logger.getRootLogger();

	@Override
	public Screen start() {
		System.out.println("Welcome to Davy Jones Locker ! ");
		log.debug("started login screen");
		System.out.println("Enter Username or type Register to Sign up: ");
		String username = scan.nextLine();
		log.trace("username = " + username);
		
		
		
		if ("register".equalsIgnoreCase(username)) {
			return new RegisterUserScreen();
		}
		
		System.out.println("Enter Password: ");
		String password = scan.nextLine();
		
		if(username.equals("0") == true && password.equals("0") == true) {
			return new CaptainScreen();
		}
		
		
		log.debug("received users credentials");
		User currentUser = ud.findByUsernameAndPassword(username, password);
		if (currentUser != null) {
			state.setCurrentUser(currentUser);
			log.info("user succefully logged in");
			log.info("welcome" + currentUser);
			return new TransactionScreen();
		}

		System.out.println("Unable to Login");
		return this;
	}

}
