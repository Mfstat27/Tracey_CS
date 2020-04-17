package com.rentalockercasestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RentALockerHomeController {

	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView indexHandler() {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}

}
