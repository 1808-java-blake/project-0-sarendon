package com.revature.screens;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.revature.beans.Transaction;
import com.revature.beans.User;

public class CaptainScreen implements Screen {

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		String check;

		System.out.println("\n");
		System.out.println("|\\   ___ \\|\\   __  \\|\\  \\    /  /|\\  \\  /  /|       |\\  \\|\\   __  \\|\\   ___  \\|\\  ___ \\ |\\   ____\\         |\\  \\     |\\   __  \\|\\   ____\\|\\  \\|\\  \\ |\\  ___ \\ |\\   __  \\    \r\n" + 
				"\\ \\  \\_|\\ \\ \\  \\|\\  \\ \\  \\  /  / | \\  \\/  / /       \\ \\  \\ \\  \\|\\  \\ \\  \\\\ \\  \\ \\   __/|\\ \\  \\___|_        \\ \\  \\    \\ \\  \\|\\  \\ \\  \\___|\\ \\  \\/  /|\\ \\   __/|\\ \\  \\|\\  \\   \r\n" + 
				" \\ \\  \\ \\\\ \\ \\   __  \\ \\  \\/  / / \\ \\    / /      __ \\ \\  \\ \\  \\\\\\  \\ \\  \\\\ \\  \\ \\  \\_|/_\\ \\_____  \\        \\ \\  \\    \\ \\  \\\\\\  \\ \\  \\    \\ \\   ___  \\ \\  \\_|/_\\ \\   _  _\\  \r\n" + 
				"  \\ \\  \\_\\\\ \\ \\  \\ \\  \\ \\    / /   \\/  /  /      |\\  \\\\_\\  \\ \\  \\\\\\  \\ \\  \\\\ \\  \\ \\  \\_|\\ \\|____|\\  \\        \\ \\  \\____\\ \\  \\\\\\  \\ \\  \\____\\ \\  \\\\ \\  \\ \\  \\_|\\ \\ \\  \\\\  \\| \r\n" + 
				"   \\ \\_______\\ \\__\\ \\__\\ \\__/ /  __/  / /        \\ \\________\\ \\_______\\ \\__\\\\ \\__\\ \\_______\\____\\_\\  \\        \\ \\_______\\ \\_______\\ \\_______\\ \\__\\\\ \\__\\ \\_______\\ \\__\\\\ _\\ \r\n" + 
				"    \\|_______|\\|__|\\|__|\\|__|/  |\\___/ /          \\|________|\\|_______|\\|__| \\|__|\\|_______|\\_________\\        \\|_______|\\|_______|\\|_______|\\|__| \\|__|\\|_______|\\|__|\\|__|\r\n" + 
				"                                \\|___|/                                                    \\|_________|                                                                     ");
		System.out.println("\n");
		
		
		
		System.out.println("Welcome to the Captains Portal! ");
		System.out.println("Enter 1: To View all Crew Memebers: ");
		System.out.println("Enter 2: To View History of Selected User");
		System.out.println("Enter 3: To Return to Login Screen");
		check = scan.nextLine();

		switch (check) {
		case "1":

			File folder = new File("src/main/resources/users/");
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println("File " + listOfFiles[i].getName());
				} else if (listOfFiles[i].isDirectory()) {
					System.out.println("Directory " + listOfFiles[i].getName());
				}

			}

			return new CaptainScreen();
			
		case "2":
			
			
			System.out.println("Enter Crew Memeber's Name: ");
			check = scan.nextLine();
			
			try (ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream("src/main/resources/users/" + check + ".txt"))) {

				User u = (User) ois.readObject(); // retrieve the user if it can
				// verify that the password matches
				

				for(Transaction T: u.TransactionHistory ) {
					System.out.println("Deposits:  " + T.deposit + " Withdrawl: " + T.withdraw);
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		
		
			return new CaptainScreen();
		case "3":
			return new LoginScreen();
			
		}
		return new CaptainScreen();
	}
}