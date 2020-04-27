package com.rentalockercasestudy.controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.rentalockercasestudy.dao.UserDao;
import com.rentalockercasestudy.models.User;
import com.rentalockercasestudy.services.UserServices;
import javax.swing.JOptionPane;
@Controller
@SessionAttributes( {"userSession"})
public class RentALockerRegistrationController  {
	
	protected static final int ERROR_MESSAGE = 0;

	@RequestMapping("/register")
	public String registrationHandler() {
		return "registration";
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields(new String[] {"user.getUserNameEmail()", "user.getPassword()"});
	}
	
	@ModelAttribute("userSession")
	public User setUpUserSession() {
		return new User();
	}
	
	@RequestMapping(value = "registration", name = "userSession", method=RequestMethod.POST)
	public ModelAndView createNewUserHandler(@ModelAttribute User newUser)  {
		UserDao ud = new UserDao();
		String viewName = "registration";
		int result = 0;
		ModelAndView mav = new ModelAndView();
		mav.addObject("userSession", newUser);
		mav.setViewName(viewName);
		boolean userExists = ud.findUser(newUser.getUserNameEmail()) == null;
		if(!userExists) {
			String duplicateEntry = "Sorry a user with that email already exists";
			System.out.println(duplicateEntry);
			JFrame parent = new JFrame();
			parent.setVisible(true);
			JOptionPane.showMessageDialog(parent, duplicateEntry, "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			newUser = new User(newUser.getFirstName(),newUser.getLastName(),newUser.getUserNameEmail(),newUser.getPassword());
			result = ud.addUser(newUser);
			mav.setViewName("profilepage");
		}
		return mav;
	}
	

	}

