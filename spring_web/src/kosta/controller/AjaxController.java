package kosta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.model.Board;
import kosta.model.BoardDao;

@RestController
public class AjaxController {
	
	private BoardDao dao;
	
	
	@Autowired
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}



	@RequestMapping("/json_list")
	public List<Board> json_list(){
		List<Board> list = dao.listBoard();
		
		return list;
	}
}
