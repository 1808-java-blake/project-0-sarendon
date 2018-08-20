package com.revature.screens;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Transaction;
import com.revature.beans.User;
import com.revature.daos.TransactionDao;
import com.revature.daos.UserDao;
import com.revature.util.AppState;

public class CaptainScreen implements Screen {

	@Override
	public Screen start() {

		Scanner scan = new Scanner(System.in);
		TransactionDao Td = TransactionDao.currentTransactionDao;
		UserDao ud = UserDao.currentUserDao;
		
		String val;
		int id;
		System.out.println("Welcome to the Captains Portal!");
		System.out.println("Select 1: View All Crew Members");
		System.out.println("Select 2: View Crew Member's Transaction History");
		System.out.println("Select 3: Return to Login Page");
		val = scan.nextLine();
		

		switch (val) {

		case "1":
			System.out.println("You have entered case 1");
				
				List<User> crew = ud.findByUserId();
				
				crew.stream().forEach((each) -> {
				
				System.out.println("user id : " + each.getId() + "    " + "username : " + each.getUsername());
				
			});
			
			break;
		case "2":
			System.out.println("You have entered case 2");
			System.out.println("Enter the ID Number of the Crew Member: ");
			id = scan.nextInt();
			
			List<Transaction> Transaction = Td.findByUserId(id);
			
			if(Transaction.isEmpty()) {
				System.out.println("Invalid ID, No History Found! Try again! ");
			}
					Transaction.stream().forEach((each) -> {
						
						System.out.println(each);
						
					});

			return new CaptainScreen();
		case "3":
			return new LoginScreen();

		}

		return new CaptainScreen();
	}

}
