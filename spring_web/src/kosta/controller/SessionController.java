package kosta.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {
	
	@RequestMapping("/session_req")
	public String session_req(HttpSession session){
		session.setAttribute("name", "kosta");
		return "session/session_req.jsp";
	}
	
	
	@RequestMapping("/session")
	public String session_exe(HttpSession session){
		System.out.println("핵심로직 실행");
		
		return "/session/success.jsp";
	}
	

	
}
