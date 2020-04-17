package com.rentalockercasestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rentalockercasestudy.models.LockerAddress;
import com.rentalockercasestudy.services.LockerAddressServices;

import java.util.ArrayList;

import org.springframework.*;
@Controller
public class LockerAddressController {

	@RequestMapping("/lockerlocations")
	public ModelAndView lockerLocationsHandler() {
		ModelAndView mav = new ModelAndView("/lockerlocations");
		LockerAddressServices las  = new LockerAddressServices();
		ArrayList<LockerAddress> lockerAddresses = las.testgetAllLockerAddresses();
		mav.addObject("locations", lockerAddresses);
		return mav;
	}
}
