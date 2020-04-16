package rentalockercasestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FaqController {

	@RequestMapping("/faq")
	public ModelAndView faqHandler() {
		ModelAndView mav = new ModelAndView("/faq");
		return mav;
	}
}	
