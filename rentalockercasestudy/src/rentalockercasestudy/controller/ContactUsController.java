package rentalockercasestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactUsController {
	
	@RequestMapping("/contactus")
	public ModelAndView contactUsHandler() {
		ModelAndView mav = new ModelAndView("contactus");
		return mav;
	}
}
