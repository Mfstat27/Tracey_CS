package com.rentalockercasestudy.dao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.rentalockercasestudy.models.User;

public interface UserDaoI {

	public int addUser(User newUser) throws NoSuchAlgorithmException, InvalidKeySpecException;
	public User deleteUserAccount(User inputUser);
	public int updateUser(User inputUser);
	public User findUser(User inputUser);
}
