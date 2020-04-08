package rentalockercasestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RentALockerRegistrationController {
	
	@RequestMapping("/registration")
	public ModelAndView loginHandler() {
		ModelAndView mav = new ModelAndView("registration");
		return mav;
	}
	
}
