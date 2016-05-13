package kosta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class boardController {
	
	@RequestMapping("/insert_form.do")
	public ModelAndView insert_form(){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("insert_form");
		mav.addObject("title","글 작성하기");
		return mav;
	}
	

}
