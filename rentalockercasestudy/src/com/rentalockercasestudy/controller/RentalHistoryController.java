package com.rentalockercasestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RentalHistoryController {
	
	@RequestMapping("/rentalhistory") 
		public ModelAndView rentalHistoryHandler() {
			ModelAndView mav = new ModelAndView("rentalhistory");
			return mav;
		}
}
