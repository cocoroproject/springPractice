package kosta.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kosta.model.MemberService;
import kosta.model.RegisterCommand;

@Controller
@RequestMapping("/register")
public class RegisterController {
	private MemberService memberService;
	
	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/step1")
	public String handle1(){
		return "register/step1";
	}
	
	@RequestMapping("/step2")
	public String handle2(@RequestParam(value="agree", defaultValue="false") 
											boolean agree, Model model){
		if(!agree){
			return "register/step1";
		}
		model.addAttribute("registerRequest", new RegisterCommand());
		
		return "register/step2";
	}
	
	@RequestMapping("/step3")
	public String handle3(@ModelAttribute("registerRequest") 
							@Valid RegisterCommand command, BindingResult errors){
		
		try {
			if(errors.hasErrors()){
				return "register/step2";
			}			
			memberService.regist(command);			
			return "register/step3";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "register/step2";
		}		
	}
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new RegisterRequestValidator());
	}
	
}









