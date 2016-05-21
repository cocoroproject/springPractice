package kosta.model;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Board implements Serializable {
	private int seq, hitcount;
	
	@NotEmpty(message="반드시 제목을 입력하세요.")
	@Size(min=2, max=10, message="2자 이상")
	private String title;
	
	@NotEmpty(message="반드시 작성자를 입력하세요.")
//	@Pattern(regexp="[0-9a-zA-Z가-힣]", message="특수문자 입력금지")
	private String writer;
	
	
	private String contents;
	private String regdate;
	
	// 파일업로드
	private MultipartFile uploadFile;
	private String filename;
	
	
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", hitcount=" + hitcount + ", title=" + title + ", writer=" + writer
				+ ", contents=" + contents + ", regdate=" + regdate + "]";
	}
	
	
}
