package com.rentalockercasestudy.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.persistence.EntityManager;
import java.sql.DriverManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rentalockercasestudy.models.User;



import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class UserDao implements UserDaoI {
	final static String persistenceUnitName = "com.rentalockercasestudy";
	
	
	@Override
	public int addUser(User newUser)  {
		int result = 0;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();	
		em.getTransaction().begin();
		em.persist(newUser);
		em.getTransaction().commit();
		result = 1;
		}catch(NullPointerException e) {
			result = 0;
		}finally {
		em.close();
		emf.close();
		}
		return result;
	}

	@Override
	public User deleteUserAccount(User inputUser) {
		User user = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			em = emf.createEntityManager();	

			em.getTransaction().begin();

			user = em.find(User.class, 1);//replace with query!
			if (user != null) {
				em.remove(user); // remove tries 2 operations first find and then remove but it is && 

				em.getTransaction().commit();
			}
		}catch(Exception e) {
			user = null;
		}finally {
			em.close();
			emf.close();
		}

		return user;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findUser(String userNameEmail) {
		User foundUser = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();	
		
		Query query = em.createQuery("select u from User u where u.userNameEmail like :givenUserEmail");
		query.setParameter("givenUserEmail", userNameEmail);
		foundUser = (User) query.getSingleResult();
		
		}catch(Exception e) {
			foundUser = null;
		}finally {
		em.close();
		emf.close();
		}
		return foundUser;
	}		
	@Override
	public String findUserByEmail(String userNameEmail) {
		String foundUserEmail = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();	
		
		Query query = em.createQuery("select u.userNameEmail from User u where u.userNameEmail like :givenUserEmail");
		query.setParameter("givenUserEmail", userNameEmail);
		foundUserEmail = (String) query.getSingleResult();
		
		}catch(Exception e) {
			foundUserEmail = null;
		}finally {
		em.close();
		emf.close();
		}
		return foundUserEmail;
	}		
	
//	public int getUserByUsernameAndPassword(User userLogin) {
//		UserDao ud = new UserDao();
//		int result = 0;
//		
//		EntityManagerFactory emf= Persistence.createEntityManagerFactory(persistenceUnitName);
//		EntityManager em = emf.createEntityManager();
//		 try {
//		Query query = em.createQuery("select u from User u where u.userNameEmail = :givenUserName");
//		query.setParameter("givenUserName", userLogin.getUserNameEmail());
//		User ul = (User)query.getSingleResult();
//		System.out.println(ul);
//		boolean checkpword = ud.decodePassword(userLogin.getPassword(), ul.getPassword());
//		if(ul != null && checkpword) {
//			result = 1;
//		
//		}else if(ul != null && !checkpword) {
//			result = 2;
//			
//		} else {
//			result = 0;
//		}
//		//em.find(UserLogin.class, password);
//		 }catch(NoResultException n) {
//			
//		 }finally {
//	
//		em.close();
//		emf.close();
//		 }
//		return result;
//	}
	
	public User getUserByUsernameAndPassword(User userLogin) {
		UserDao ud = new UserDao();
		User foundUser = null;
		User user = null;
		EntityManagerFactory emf= Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		 try {
			//foundUser = em.find(User.class, userLogin.getUserNameEmail());
		Query query = em.createQuery("select u from User u where u.userNameEmail = :givenUserName and u.firstName = :givenFirstName");
		query.setParameter("givenUserName", userLogin.getUserNameEmail());
		query.setParameter("givenFirstName", userLogin.getFirstName());
		foundUser = (User)query.getSingleResult();
		System.out.println(foundUser);
		boolean checkpword = ud.decodePassword(userLogin.getPassword(), foundUser.getPassword());
		if(foundUser != null && checkpword) {
			System.out.println("Login success");
		}else {
			System.out.println("Login error");
		}
		//em.find(UserLogin.class, password);
		 }catch(NoResultException n) {
			
		 }finally {
	
		em.close();
		emf.close();
		 }
		return foundUser;
	}

	
//    public User checkLogin(String email, String password) throws SQLException,
//            ClassNotFoundException {
//        
//        UserDao ud = new UserDao();
//        
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/RentaLockerCaseStudy", "root",  "ZAHIRA11");
//        String sql = "SELECT * FROM user WHERE email = ? and password = ?";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, email);
//        statement.setString(2, password);
//        ResultSet result = statement.executeQuery();
//        boolean checkpw = ud.decodePassword(password, result.getString("password"));
//        User user = null;
// 
//        if (result.next()&&checkpw) {
//            user = new User();
//            user.setFirstName(result.getString("firstName"));
//            user.setUserNameEmail(email);
//        }
// 
//        connection.close();
// 
//        return user;
//    }
	
	
	public static String encodePassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
		return encodedPassword;
	}

	public boolean decodePassword(String password, String encodedPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		return isPasswordMatch;
	}
	
	@Override
	public  void printResult(int result) {
		switch(result) {
		case 0: System.out.println("User does not exist"); break;
		case 1: System.out.println("User Exists"); break;
		case 2:System.out.println("Invalid Password"); break;
		case 3:System.out.println("Application Error: Try again!!!"); break;
		default : System.out.println("ERROR 9999 !!!!");
		}
	}
		@Override
		public  void printResult(int result, User userLogin) {
			try {
			switch(result) {
			case 0: System.out.println("User does not exist" + " " +userLogin.toString()); break;
			case 1: System.out.println("User Exists" + " "+ userLogin.toString()); break;
			case 2:System.out.println("Invalid Password"+ " "+ userLogin.toString()); break;
			case 3:System.out.println("Application Error: Try again!!!" + " "+userLogin.toString()); break;
			default : System.out.println("ERROR 9999 !!!!" + " "+ userLogin.toString());
			}
			}catch(NullPointerException n) {
				System.out.println("ERROR 555: null");
			}
	}
}


