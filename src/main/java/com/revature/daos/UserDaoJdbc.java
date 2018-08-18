package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDaoJdbc implements UserDao {
	private ConnectionUtil cu = ConnectionUtil.cu;
	private Logger log = Logger.getRootLogger();
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void createUser(User u) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO user_info (username, password, age, firstname, lastname,balance) VALUES (?,?,?,?,?,?)");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setInt(3, u.getAge());
			ps.setString(4, u.getFirstName());
			ps.setString(5, u.getLastName());
			ps.setInt(6, u.getBalance());
			int recordsCreated = ps.executeUpdate();
			log.trace(recordsCreated + " records created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			for(StackTraceElement ste: e.getStackTrace()) {
				log.error(ste);
			}
			log.warn("failed to create new user");
		}

	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		try (Connection conn = cu.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM user_info WHERE username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
					
			if(rs.next()) {
				User u = new User();
				u.setAge(rs.getInt("age"));
				u.setFirstName(rs.getString("firstname"));
				u.setLastName(rs.getString("lastname"));
				u.setUsername(rs.getString("username"));
				u.setId(rs.getInt("user_id"));
				u.setBalance(rs.getInt("balance"));
				return u;
			} else {
				log.warn("failed to find user with provided credentials from the db");
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void updateUserBalance(int userid , int updatebalance) {
		

		try (Connection conn = cu.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE user_info SET balance = ? WHERE user_id = ?");
			ps.setInt(1, updatebalance);
			ps.setInt(2, userid);
			int recordupate = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		
	}

}
