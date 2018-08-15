package com.revature.usertest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.User;

public class TransactionTest {

	private static User user1; 
	private static User user2;
	private static User user3;
	
	@BeforeClass
	public static void setUp() {
		user1 = new User("Red","Blue","Red", "Blue", 20);
		user2 = new User("White", "Black", "White", "Black", 18);
		user3 = new User("Black", "Blue", "Black", "Blue", 21);
	}
	
	@Test
	public void test() {//test 1
		assertTrue()
	}

	@Test
	public void test2() {//test 2
		fail("Not yet implemented");
	}
	
	@Test
	public void test3() {//test 3
		fail("Not yet implemented");
	}
	
	
}
