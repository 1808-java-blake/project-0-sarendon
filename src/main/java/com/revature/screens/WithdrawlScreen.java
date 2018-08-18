package com.revature.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.Transaction;
import com.revature.beans.User;
import com.revature.beans.Transaction;
import com.revature.daos.TransactionDao;
import com.revature.daos.UserDao;
import com.revature.util.AppState;

public class WithdrawlScreen implements Screen {
	private AppState state = AppState.state;
	private User current = state.getCurrentUser();
	private Logger log = Logger.getRootLogger();
	private Scanner scan = new Scanner(System.in);
	private TransactionDao td = TransactionDao.currentTransactionDao;
	private UserDao ud =  UserDao.currentUserDao;


	@Override
	public Screen start() {
		User currentUser = state.getCurrentUser();
		if(currentUser == null) {
			return new LoginScreen();
		}
		try {
			Transaction T = new Transaction();
			System.out.println("How many Dubloons do you want to Withdraw?");
			String d = scan.nextLine();
			int withdraw = Integer.parseInt(d);
			T.setWithdraw(withdraw);
			int updatebalance = current.getBalance() - withdraw;
			current.setBalance(updatebalance);
			state.setCurrentUser(current);
			ud.updateUserBalance(current.getId(), updatebalance);
			T.setUserId(currentUser.getId());
			int TransactionId = td.createTransaction(T);
			if(TransactionId == 0) {
				log.error("Failed to Create Transaction");
				return new LoginScreen();
			}
			T.setTransactionId(TransactionId);
			log.info("Created Transaction" + T);
			
		} catch (NumberFormatException e) {
			System.out.println("Invalid number");
		}

		return new TransactionScreen();
	}

}
