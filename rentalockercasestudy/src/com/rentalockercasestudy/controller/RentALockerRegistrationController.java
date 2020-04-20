package com.rentalockercasestudy.controller;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rentalockercasestudy.models.User;
import com.rentalockercasestudy.services.UserServices;

@Controller
public class RentALockerRegistrationController  {
	
	@RequestMapping("/register")
	public String registrationHandler() {
		return "registration";
	}
	
	@RequestMapping("/registration")
	public ModelAndView createNewUserHandler(@ModelAttribute User newUser) throws NoSuchAlgorithmException, InvalidKeySpecException {
		UserServices us = new UserServices();
		String viewName = "registration";
		int result = 0;
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		boolean userExists = us.testFindUserService(newUser.getUserNameEmail()) == null;
		if(!userExists) {
			String duplicateEntry = "Sorry a user with that email already exists";
			mav.addObject("duplicateEntry", duplicateEntry);
		}else {
			result = us.testAddUserService(newUser);
			String message = "Employee saved";
			mav.addObject("xMessage", message);
			mav.setViewName("profilepage");
		}
		return mav;
	}
	

	}

