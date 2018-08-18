package com.revature.daos;

import java.util.List;

import com.revature.beans.Transaction;

public interface TransactionDao {
	public static final TransactionDao currentTransactionDao = new TransactionDaoJdbc();
	
	int createTransaction(Transaction T);

	List<Transaction> findByUserId(int userId);
	
}
