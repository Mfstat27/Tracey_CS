package rentalockercasestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RentALockerSelectALockerController {
	
	@RequestMapping("/selectalocker")
	public ModelAndView loginHandler() {
		ModelAndView mav = new ModelAndView("selectalocker");
		return mav;
	}
}
