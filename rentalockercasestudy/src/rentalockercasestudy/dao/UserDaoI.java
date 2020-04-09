package rentalockercasestudy.dao;

import rentalockercasestudy.models.User;

public interface UserDaoI {

	public int addUser(User newUser);
	public User deleteUserAccount(String userNameEmail);
}
