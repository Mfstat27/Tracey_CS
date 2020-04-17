package com.rentalockercasestudy.controller;

import javax.servlet.annotation.WebServlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.rentalockercasestudy.models.User;

@Controller
@SessionAttributes( {})
public class RentALockerLoginController {

	@RequestMapping("/login")
	public ModelAndView loginHandler() {
		ModelAndView mav = new ModelAndView("login");
		//mav.addObject(userLogin);
//		@ModelAttribute User userLogin
		return mav;
	}

}
