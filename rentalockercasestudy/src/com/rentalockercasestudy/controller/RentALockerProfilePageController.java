package com.rentalockercasestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RentALockerProfilePageController {
	
	@RequestMapping("/profilepage")
	public ModelAndView loginHandler() {
		ModelAndView mav = new ModelAndView("profilepage");
		return mav;
	}
}
