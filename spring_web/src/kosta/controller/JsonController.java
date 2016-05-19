package kosta.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.model.Member;

@RestController
public class JsonController {
	
	@RequestMapping("/spring_json")
	public List<Member> spring_json(){
		List<Member> list = new ArrayList<Member>();
		list.add(new Member("홍길동", 20));
		list.add(new Member("이승엽", 35));
		
		return list;
	}
}
