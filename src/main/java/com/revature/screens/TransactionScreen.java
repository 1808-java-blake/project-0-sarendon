package com.revature.screens;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.Transaction;
import com.revature.beans.User;
import com.revature.daos.TransactionDao;
import com.revature.util.AppState;

public class TransactionScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private TransactionDao Td = TransactionDao.currentTransactionDao;
	private AppState state = AppState.state;
	private User u = state.getCurrentUser();
	
	

	public Screen start() {
		System.out.println("Please chose from following options:");
		System.out.println("Enter 1: Deposit");
		System.out.println("Enter 2: Withdraw");
		System.out.println("Enter 3: Check Balance");
		System.out.println("Enter 4: See Transaction History");
		System.out.println("Enter 5: Go To Login Screen");
		String selection = scan.nextLine();
		switch (selection) {
		case "1":
			return new DepositScreen();
		case "2":
			return new WithdrawlScreen();
		case "3":
			System.out.println("Here is your Balance: " + u.getBalance());
			return new TransactionScreen();
		case "4":
			List<Transaction> Transaction = Td.findByUserId(state.getCurrentUser().getId());
			Transaction.stream().forEach((each) -> {
				System.out.println(each);
			});
			return new TransactionScreen();
		case "5":
			return new LoginScreen();
		default:
			break;
		}

		return this;
	}

}
