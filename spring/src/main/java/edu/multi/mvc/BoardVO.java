package edu.multi.mvc;

import org.springframework.stereotype.Component;

@Component
public class BoardVO {
	int seq;
	String title;
	String contents;
	String writer;
	String time;
	int password;
	int viewcount;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	@Override
	public String toString() {
		return "게시물번호=" + seq + ", 제목=" + title + ", 내용=" + contents + ", 작성자=" + writer + ", 시간="
				+ time + ", 비밀번호=" + password + ", 조회수=" + viewcount + "]";
	}
	
	

}
