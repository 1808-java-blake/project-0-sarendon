package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Transaction;
import com.revature.util.ConnectionUtil;

public class TransactionDaoJdbc implements TransactionDao {
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil cu = ConnectionUtil.cu;

	@Override
	public int createTransaction(Transaction T) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO user_transaction (user_id, deposit, withdrawl) VALUES (?,?,?)",
					new String[] {"transaction_id"});
			ps.setInt(1, T.getUserId());
			ps.setInt(2, T.getDeposit());
			ps.setInt(3, T.getWithdraw());
			int recordsCreated = ps.executeUpdate();
			log.trace(recordsCreated + " records created");
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				log.trace("generated transaction id is" + rs.getInt("transaction_id"));
				return rs.getInt("transaction_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			for(StackTraceElement ste: e.getStackTrace()) {
				log.error(ste);
			}
			log.warn("failed to create new user");
		}
		return 0;
	}

	@Override
	public List<Transaction> findByUserId(int userId) {
		try (Connection conn = cu.getConnection()) {
			List<Transaction> transactionHistory = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement(
			"SELECT * FROM user_transaction WHERE user_id=?"
			);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Transaction T = new Transaction();
				T.setDeposit(rs.getInt("deposit"));
				T.setWithdraw(rs.getInt("withdrawl"));
				transactionHistory.add(T);
			}		
			return transactionHistory ;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
		
	}

}
