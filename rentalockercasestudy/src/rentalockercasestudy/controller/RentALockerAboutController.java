package rentalockercasestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RentALockerAboutController {

	@RequestMapping("/about")
	public ModelAndView loginHandler() {
		ModelAndView mav = new ModelAndView("about");
		return mav;
	}
}
