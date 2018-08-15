package com.revature.beans;

import java.io.Serializable;

public class Transaction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8695767901616092359L;
	public int deposit;
	public int withdraw;
	
	public Transaction() {
	
		deposit = 0;
		withdraw = 0;
		
	}
	
	public Transaction(int d, int w) {
		
		deposit = d;
		withdraw = w;
		
	}
	
	
}
