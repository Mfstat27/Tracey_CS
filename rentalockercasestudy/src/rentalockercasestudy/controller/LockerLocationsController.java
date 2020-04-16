package rentalockercasestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.*;
@Controller
public class LockerLocationsController {

	@RequestMapping("/lockerlocations")
	public ModelAndView lockerLocationsHandler() {
		ModelAndView mav = new ModelAndView("/lockerlocations");
		return mav;
	}
}
