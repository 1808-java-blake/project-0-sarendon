package com.revature.beans;

public class Transaction {
	private int transactionId;
	private int deposit;
	private int withdraw;
	
	private int userId;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int transactionId, int deposit, int withdraw, int userId) {
		super();
		this.transactionId = transactionId;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.userId = userId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deposit;
		result = prime * result + transactionId;
		result = prime * result + userId;
		result = prime * result + withdraw;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (deposit != other.deposit)
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (userId != other.userId)
			return false;
		if (withdraw != other.withdraw)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", deposit=" + deposit + ", withdraw=" + withdraw
				+ ", userId=" + userId + "]";
	}

	
	
}
