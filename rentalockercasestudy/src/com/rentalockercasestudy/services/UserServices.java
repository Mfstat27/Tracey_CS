package com.rentalockercasestudy.services;



import com.rentalockercasestudy.dao.UserDao;
import com.rentalockercasestudy.models.User;

public class UserServices {
//slane1
	public int testAddUserService(User newUser){
		UserDao ud = new UserDao();
		int result = ud.addUser(newUser);
		System.out.println("User Added.");
		return result;
	}
	
	public boolean testFindUserBoolService(String userNameEmail) {
		boolean userExists = false;
		UserDao ud = new UserDao();
		User foundUser = ud.findUser(userNameEmail);
		if(foundUser != null) {
			userExists = true;
			System.out.println("User found");
		}else {
			userExists = false;
			System.out.println("Sorry no user found with that information");
		}
		return userExists;
	}
	
	public User testFindUserService(String userNameEmail) {
		UserDao ud = new UserDao();
		User foundUser = ud.findUser(userNameEmail);
		if(foundUser != null) {
			System.out.println("User found");
		}else {
			System.out.println("Sorry no user found with that information");
		}
		return foundUser;
	}

	public String testFindUserByEmailService(String userNameEmail) {
		UserDao ud = new UserDao();
		String foundUserEmail = ud.findUserByEmail(userNameEmail);
		if(foundUserEmail != null) {
			System.out.println("User found");
		}else {
			System.out.println("Sorry no user found with that information");
		}
		return foundUserEmail;
	}
	
//	public int testGetUserByUsernameAndPasswordService(User userLogin) {
//		UserDao ud = new UserDao();
//		int result = ud.getUserByUsernameAndPassword(userLogin);
//		ud.printResult(result, userLogin);
//		return result;
//	}
}
