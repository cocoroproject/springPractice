package kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kosta.model.AuthInfo;
import kosta.model.LoginCommand;
import kosta.model.MemberService;

@Controller
@RequestMapping("/login")
public class LoginController {
	private MemberService memberService;

	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(LoginCommand loginCommand){
		return "login/loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(LoginCommand loginCommand, HttpServletRequest request){
		int re = 0;
		re = memberService.loginCheck(loginCommand);
		HttpSession session = request.getSession();
		
		if(re ==0){			
			return "login/loginForm";
		}else{			
			AuthInfo info = memberService.getAuthInfo(loginCommand.getEmail());
			System.out.println("authInfo: " + info.getName() );
			session.setAttribute("authInfo", info);
			
			return "login/loginSuccess";
		}		
	}
	
	
	
	
	
}








