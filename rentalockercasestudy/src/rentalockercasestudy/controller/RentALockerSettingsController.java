package rentalockercasestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RentALockerSettingsController {
	
	@RequestMapping("/settings")
	public ModelAndView loginHandler() {
		ModelAndView mav = new ModelAndView("settings");
		return mav;
	}
}
