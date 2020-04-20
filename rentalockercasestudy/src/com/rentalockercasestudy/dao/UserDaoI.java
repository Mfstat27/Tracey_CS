package com.rentalockercasestudy.dao;



import com.rentalockercasestudy.models.User;

public interface UserDaoI {

	public int addUser(User newUser);
	public User deleteUserAccount(User inputUser);
	public int updateUser(User inputUser);
	public User findUser(String userNameEmail);
	public String findUserByEmail(String userNameEmail);
	public void printResult(int result);
	public void printResult(int result, User userLogin);
}
