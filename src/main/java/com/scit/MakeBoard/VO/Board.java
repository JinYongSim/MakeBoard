package com.scit.MakeBoard.VO;

public class Board {
	private int boardSeq;
	private String id;
	private String boardTitle;
	private String boardContent;
	private String hitCount;
	private String indate;
	private String fileName;
	private String fileName_org;
	
	public Board() {
		super();
	}

	public Board(int boardSeq, String id, String boardTitle, String boardContent, String hitCount, String indate,
			String fileName, String fileName_org) {
		super();
		this.boardSeq = boardSeq;
		this.id = id;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.hitCount = hitCount;
		this.indate = indate;
		this.fileName = fileName;
		this.fileName_org = fileName_org;
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

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getHitCount() {
		return hitCount;
	}

	public void setHitCount(String hitCount) {
		this.hitCount = hitCount;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName_org() {
		return fileName_org;
	}

	public void setFileName_org(String fileName_org) {
		this.fileName_org = fileName_org;
	}

	@Override
	public String toString() {
		return "Board [boardSeq=" + boardSeq + ", id=" + id + ", boardTitle=" + boardTitle + ", boardContent="
				+ boardContent + ", hitCount=" + hitCount + ", indate=" + indate + ", fileName=" + fileName
				+ ", fileName_org=" + fileName_org + "]";
	}
	
	
}
