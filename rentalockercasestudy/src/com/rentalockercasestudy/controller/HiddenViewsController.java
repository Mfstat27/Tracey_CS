package com.rentalockercasestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HiddenViewsController {

	@RequestMapping(value="/usernameexist", method=RequestMethod.POST)
	public ModelAndView userNameExistHandler() {
		ModelAndView mav= new ModelAndView("usernameexist");
		return mav;
	}
	
	
	@RequestMapping("/contactusconfirm")
	public ModelAndView contactUsConfirmHandler() {
		ModelAndView mav = new ModelAndView("contactusconfirm"); 
			return mav;
		}
	}

