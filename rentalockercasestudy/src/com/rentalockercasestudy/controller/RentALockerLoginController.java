package com.rentalockercasestudy.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

import com.rentalockercasestudy.dao.UserDao;
import com.rentalockercasestudy.models.User;
import com.rentalockercasestudy.services.UserServices;



@Controller
@SessionAttributes( {"userSession"})
public class RentALockerLoginController {


	@RequestMapping("/loginRM") //uri
	public ModelAndView loginHandler() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields(new String[] {"user.getUserNameEmail()", "user.getPassword()"});
	}
	
	@ModelAttribute("userSession")
	public User setUpUserSession() {
		return new User();
	}
	
	@RequestMapping(value = "signInRM", name = "userSession", method=RequestMethod.GET)
	public ModelAndView loginHandler(@ModelAttribute User u, BindingResult errors) {
		ModelAndView mav = new ModelAndView("profilepage");
		System.out.println(u.toString());
		if(errors.hasErrors()) {
			mav.setViewName("errorlogin");
		}
		UserDao ud = new UserDao();
	
		User foundUser = null;
		try {
		foundUser = ud.getUserByUsernameAndPassword(u);		
		
		}catch(Exception e) {
			mav.setViewName("errorlogin");
			
		}
		if(foundUser != null) {
			mav.addObject("userSession",u);
		}
//		if(result == 0) {
//			mav.setViewName("errorlogin");
//		}
//		if(result == 2) {
//			mav.setViewName("errorlogin");
//		}
//		if(result == 3) {
//			mav.setViewName("errorlogin");
//		}else
		
		return mav;
}
	
	@RequestMapping("/signout")
	public ModelAndView signOutHandler(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", new User());
		session.invalidate();
		return mav;
	}
	
	}
	
	
	
	
	
	

	
//	@RequestMapping("/login")
//	public ModelAndView loginHandler() {
//		ModelAndView mav = new ModelAndView("login");
//		//mav.addObject(userLogin);
////		@ModelAttribute User userLogin
//		return mav;
//	}

