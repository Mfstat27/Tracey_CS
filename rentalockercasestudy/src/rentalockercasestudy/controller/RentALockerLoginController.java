package rentalockercasestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RentALockerLoginController {

	@RequestMapping("/login")
	public ModelAndView loginHandler() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

}
