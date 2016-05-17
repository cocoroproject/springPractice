package kosta.controller;

import java.util.List;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosta.model.Board;
import kosta.model.BoardDao;

@Controller
public class BoardController {
	
	
	private BoardDao dao;
	
	@Autowired
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/board_insert", method=RequestMethod.GET)
	public String insert_form(Model model){
		model.addAttribute("title","글쓰기폼");  // 뷰에 가지고 갈 데이터값
		return "/view/insert_form.jsp";  //  뷰의 이름
	}
	
	@RequestMapping(value="/board_insert", method=RequestMethod.POST)
	public String board_insert(Board board){     //파라미터로 Board 객체를 써주면 인썰트에서 저절로 보드가 넘어옴
		dao.insertBoard(board);
		return "redirect:/board_list";
	}
	
	@RequestMapping("/board_list")
	public String board_list(Model model){
		List<Board> list = dao.listBoard();
		model.addAttribute("list", list);
		return "/view/list.jsp";
		
	}
	
	@RequestMapping("/board_detail{seq}")
	public String board_detail(
		@PathVariable int seq, Model model){     // {seq}의 값을 int seq 에 전달해줌.
		Board board = dao.getBoard(seq);
		model.addAttribute("board", board);
		
		return "/view/board_detail.jsp";
	}
	
	@RequestMapping("/update_form{seq}")
	public String update_form(
		@PathVariable int seq, Model model){
		Board board = dao.getBoard(seq);
		model.addAttribute("board", board);
		return "/view/update_form.jsp";
	}
	
	@RequestMapping("/update_board")
	public String board_update(Board board){
		dao.updateBoard(board);
		return "redirect:/board_list";
	}
	
	@RequestMapping("/delete_form{seq}")
	public String delete_form(
		@PathVariable int seq, Model model){
		dao.delete_form(seq);
		return "redirect:/board_list";
	}
}
