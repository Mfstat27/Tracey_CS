package rentalockercasestudy.dao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import rentalockercasestudy.models.User;

public interface UserDaoI {

	public int addUser(User newUser) throws NoSuchAlgorithmException, InvalidKeySpecException;
	public User deleteUserAccount(String userNameEmail);
}
