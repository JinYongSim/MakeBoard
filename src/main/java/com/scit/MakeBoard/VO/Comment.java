package com.scit.MakeBoard.VO;

public class Comment {
	private int commentSeq;
	private int boardSeq;
	private String id;
	private String comments;
	private String indate;
	private int parentSeq;
	
	public Comment() {
	
	}

	

	public Comment(int commentSeq, int boardSeq, String id, String comments, String indate, int parentSeq) {
		super();
		this.commentSeq = commentSeq;
		this.boardSeq = boardSeq;
		this.id = id;
		this.comments = comments;
		this.indate = indate;
		this.parentSeq = parentSeq;
	}



	public String getIndate() {
		return indate;
	}



	public void setIndate(String indate) {
		this.indate = indate;
	}



	public int getCommentSeq() {
		return commentSeq;
	}

	public void setCommentSeq(int commentSeq) {
		this.commentSeq = commentSeq;
	}

	public int getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getParentSeq() {
		return parentSeq;
	}

	public void setParentSeq(int parentSeq) {
		this.parentSeq = parentSeq;
	}



	@Override
	public String toString() {
		return "Comment [commentSeq=" + commentSeq + ", boardSeq=" + boardSeq + ", id=" + id + ", comments=" + comments
				+ ", indate=" + indate + ", parentSeq=" + parentSeq + "]";
	}

	
	
}
