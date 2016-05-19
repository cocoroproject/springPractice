package kosta.mapper;

import java.util.List;

import kosta.model.Board;


public interface BoardMapper {
	void board_insert(Board board);
	List<Board>	listBoard();
	Board getBoard(int seq);
	void updateBoard(Board board);
	void delete_form(int seq);
//	void updateHitcount(Board board);
}
