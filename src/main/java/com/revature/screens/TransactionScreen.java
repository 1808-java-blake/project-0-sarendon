package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;

public class TransactionScreen implements Screen {
	User current;
	private Scanner scan = new Scanner(System.in);
	
	public TransactionScreen(User currentUser) {
	current = currentUser;	
	
	
	}

	public Screen start() {
//		
//		System.out.println("\n");
//		System.out.println("|\\   ___ \\|\\   __  \\|\\  \\    /  /|\\  \\  /  /|       |\\  \\|\\   __  \\|\\   ___  \\|\\  ___ \\ |\\   ____\\         |\\  \\     |\\   __  \\|\\   ____\\|\\  \\|\\  \\ |\\  ___ \\ |\\   __  \\    \r\n" + 
//				"\\ \\  \\_|\\ \\ \\  \\|\\  \\ \\  \\  /  / | \\  \\/  / /       \\ \\  \\ \\  \\|\\  \\ \\  \\\\ \\  \\ \\   __/|\\ \\  \\___|_        \\ \\  \\    \\ \\  \\|\\  \\ \\  \\___|\\ \\  \\/  /|\\ \\   __/|\\ \\  \\|\\  \\   \r\n" + 
//				" \\ \\  \\ \\\\ \\ \\   __  \\ \\  \\/  / / \\ \\    / /      __ \\ \\  \\ \\  \\\\\\  \\ \\  \\\\ \\  \\ \\  \\_|/_\\ \\_____  \\        \\ \\  \\    \\ \\  \\\\\\  \\ \\  \\    \\ \\   ___  \\ \\  \\_|/_\\ \\   _  _\\  \r\n" + 
//				"  \\ \\  \\_\\\\ \\ \\  \\ \\  \\ \\    / /   \\/  /  /      |\\  \\\\_\\  \\ \\  \\\\\\  \\ \\  \\\\ \\  \\ \\  \\_|\\ \\|____|\\  \\        \\ \\  \\____\\ \\  \\\\\\  \\ \\  \\____\\ \\  \\\\ \\  \\ \\  \\_|\\ \\ \\  \\\\  \\| \r\n" + 
//				"   \\ \\_______\\ \\__\\ \\__\\ \\__/ /  __/  / /        \\ \\________\\ \\_______\\ \\__\\\\ \\__\\ \\_______\\____\\_\\  \\        \\ \\_______\\ \\_______\\ \\_______\\ \\__\\\\ \\__\\ \\_______\\ \\__\\\\ _\\ \r\n" + 
//				"    \\|_______|\\|__|\\|__|\\|__|/  |\\___/ /          \\|________|\\|_______|\\|__| \\|__|\\|_______|\\_________\\        \\|_______|\\|_______|\\|_______|\\|__| \\|__|\\|_______|\\|__|\\|__|\r\n" + 
//				"                                \\|___|/                                                    \\|_________|                                                                     ");
//		System.out.println("\n");
		
		
		
		System.out.println("Please choose from following options:");
		System.out.println("Enter 1: Deposit Dubloons ");
		System.out.println("Enter 2: Withdraw Dubloons ");
		System.out.println("Enter 3: Check Balance ");
		System.out.println("Enter 4: View Transaction History ");
		System.out.println("Enter 5: Return to Login Screen ");
		String selection = scan.nextLine();
		
		switch (selection) {
		case "1":
//			String check;
//			int value;
//			String check2;
//			System.out.println("How many Dubloons to deposit? ");
//			check = scan.nextLine();
//			System.out.println("Are you sure you want to deposit " + check + " Dubloons");
//			System.out.println("Yes or No ? ");
//			check2 = scan.nextLine();
//			
//			if("yes".equalsIgnoreCase(check2) == true) {
//				value = Integer.parseInt(check);
//				current.balance = current.balance + value;
//				Transaction Deposit = new Transaction(value,0);
//				current.TransactionHistory.add(Deposit);
//				UserSerializer.us.updateUser(current);
//				
//				
//				
//			}
//			else {
//				return new TransactionScreen(current);
//			}
//			
//			return new TransactionScreen(current);
			
			
		case "2":
//			String check3;
//			int value2;
//			String check4;
//			System.out.println("How many Dubloons to Withdraw? ");
//			check3 = scan.nextLine();
//			System.out.println("Are you sure you want to withdraw " + check3 + " Dubloons");
//			System.out.println("Yes or No ? ");
//			check4 = scan.nextLine();
//			
//			if(check4.equalsIgnoreCase("yes") == true) {
//				value2 = Integer.parseInt(check3);
//				current.balance = current.balance - value2;
//				Transaction Withdraw = new Transaction(0,-value2);
//				current.TransactionHistory.add(Withdraw);
//				UserSerializer.us.updateUser(current);
//			}
//			else {
//				return new TransactionScreen(current);
//			}
//			
//			return new TransactionScreen(current);
//			
		case "3":
			System.out.println("Here is your balance: " + current.balance + " Dubloons");
			return new TransactionScreen(current);
			
		case "4":
			System.out.println("Here is your Transaction History : ");
//			for(Transaction T : current.TransactionHistory) {
//				System.out.println("Deposits : " +  T.deposit + "  Withdrawals : " + T.withdraw);				
//			}
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}			
//			return new TransactionScreen(current);
			break;
			
		case "5":
			return new LoginScreen();
		
		}

		return new TransactionScreen(current);
	}

}
