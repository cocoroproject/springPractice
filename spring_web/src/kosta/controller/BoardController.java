package kosta.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kosta.model.Board;
import kosta.model.BoardDao;

@Controller
public class BoardController {
	
	
	private BoardDao dao;
	private String uploadDir = "/Users/cocoro/Documents/upload";
	
	@Autowired
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/board_insert", method=RequestMethod.GET)
	public String insert_form(Model model){
		model.addAttribute("title","글쓰기폼");  // 뷰에 가지고 갈 데이터값
		return "insert_form";  //  뷰의 이름
	}
	
	@RequestMapping(value="/board_insert", method=RequestMethod.POST)
	public String board_insert(@ModelAttribute("boardRequest") @Valid Board board, BindingResult errors) {     //파라미터로 Board 객체를 써주면 인썰트에서 저절로 보드가 넘어옴
		
		if(errors.hasErrors())
		{
			return "insert_form";
		}
		
		//파일 업로드
		MultipartFile multiPartFile = board.getUploadFile();
		if(multiPartFile != null)
		{
			String filename = multiPartFile.getOriginalFilename(); // 업로드 할 파일의 실제이름 얻기
			board.setFilename(filename);
			
			
			try {
				multiPartFile.transferTo(new File(uploadDir, filename));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
		dao.board_insert(board);
		return "redirect:/board_list";
	}
	
	@RequestMapping("/spring_ajax")
	public String spring_ajax(){
		return "/view/getSearchResult.jsp";
	}
	
	
	@RequestMapping("/board_list")
	public String board_list(Model model){
		List<Board> list = dao.listBoard();
		model.addAttribute("list", list);
		return "list";
		
	}
	
	@RequestMapping("/board_detail{seq}")
	public String board_detail(
		@PathVariable int seq, Model model){     // {seq}의 값을 int seq 에 전달해줌.
		Board board = dao.getBoard(seq);
		model.addAttribute("board", board);
		
		return "board_detail";
	}
	
	@RequestMapping("/update_form{seq}")
	public String update_form(
		@PathVariable int seq, Model model){
		Board board = dao.getBoard(seq);
		model.addAttribute("board", board);
		return "update_form";
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
	
	@RequestMapping("/board_download")
	public ModelAndView fileDown(@RequestParam String filename)throws Exception{
		File file = new File(uploadDir, filename);
		
		return new ModelAndView("downloadView", "downloadFile", file);
	}
}
