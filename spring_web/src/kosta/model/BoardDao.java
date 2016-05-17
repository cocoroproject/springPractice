package kosta.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	private JdbcTemplate myJdbcTemplate;

	@Autowired
	public void setMyJdbcTemplate(JdbcTemplate myJdbcTemplate) {
		this.myJdbcTemplate = myJdbcTemplate;
	}

	public void insertBoard(Board board) {
		String sql = "insert into board" + "(seq, title, writer, contents, regdate, hitcount) "
				+ "values(board_seq.nextval, ?, ?, ?, sysdate, 0)";

		Object[] values = { board.getTitle(), board.getWriter(), board.getContents() };

		myJdbcTemplate.update(sql, values);
	}

	public List<Board> listBoard() {
		String sql = "select * from board order by seq desc";

		RowMapper<Board> mapper = new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int arg1) throws SQLException {
				Board board = new Board();
				board.setContents(rs.getString("contents"));
				board.setHitcount(rs.getInt("hitcount"));
				board.setRegdate(rs.getString("regdate"));
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));

				return board;
			}

		};

		List<Board> list = myJdbcTemplate.query(sql, mapper); // List를 리턴함
		return list;
	}

	public Board getBoard(int seq) {
		String sql = "select * from board where seq=?";
		Object values[] = {seq};
		RowMapper<Board> mapper = new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int arg1) throws SQLException {
				Board board = new Board();
				board.setContents(rs.getString("contents"));
				board.setHitcount(rs.getInt("hitcount"));
				board.setRegdate(rs.getString("regdate"));
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));

				return board;
			}

		};
		Board board = myJdbcTemplate.queryForObject(sql, values, mapper);
		return board;
	}
	
	
	public void updateBoard(Board board) {
		String sql = "update board set contents=? where seq=?";

		Object[] values = {board.getContents(), board.getSeq() };

		myJdbcTemplate.update(sql, values);
	}

	public void delete_form(int seq) {
		String sql = "delete from board where seq=?";
		Object[] values = {seq};
		
		myJdbcTemplate.update(sql, values);
	}
}
