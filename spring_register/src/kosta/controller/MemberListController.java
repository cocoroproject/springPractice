package kosta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kosta.model.ListCommand;
import kosta.model.Member;
import kosta.model.MemberService;

@Controller
public class MemberListController {
	private MemberService memberService;

	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/member/list")
	public String list(@ModelAttribute("cmd") ListCommand listCommand,
								Model model){
		List<Member> members = memberService.selectByRegdate(
				listCommand.getFrom(), listCommand.getTo());
		
		model.addAttribute("members", members);
		
		return "member/memberList";
	}
}












