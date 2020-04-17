package com.rentalockercasestudy.services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.rentalockercasestudy.dao.UserDao;
import com.rentalockercasestudy.models.User;

public class UserServices {
//slane1
	public int testAddUserService(User newUser) throws NoSuchAlgorithmException, InvalidKeySpecException {
		UserDao ud = new UserDao();
		int result = ud.addUser(newUser);
		System.out.println("User Added.");
		return result;
	}
	
	public boolean testFindUserBoolService(User inputUser) {
		boolean userExists = false;
		UserDao ud = new UserDao();
		User foundUser = ud.findUser(inputUser);
		if(foundUser != null) {
			userExists = true;
			System.out.println("User found");
		}else {
			userExists = false;
			System.out.println("Sorry no user found with that information");
		}
		return userExists;
	}
	
	public User testFindUserService(User inputUser) {
		UserDao ud = new UserDao();
		User foundUser = ud.findUser(inputUser);
		if(foundUser != null) {
			System.out.println("User found");
		}else {
			System.out.println("Sorry no user found with that information");
		}
		return foundUser;
	}

}
