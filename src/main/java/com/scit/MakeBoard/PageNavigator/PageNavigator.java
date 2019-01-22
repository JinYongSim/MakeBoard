package com.scit.MakeBoard.PageNavigator;

public class PageNavigator {
	// 조건
	private int boardPerPage;// 페이지당 글의 갯수
	private int pagePerGroup;// 페이지그룹 당 페이지의 갯수
	private int currentPage;// 현재페이지
	private int totalRecord;// 전체 게시글 수
	private int totalPage;// 전체 페이지수
	private int currentPageGroup;// 현재페이지그룹
	// 구해야할값
	private int startPageGroup;// 현재그룹의 첫페이지
	private int endPageGroup;// 현재그룹의 끝페이지
	private int startBoardPage;// 현재페이지의 첫글 위치

	public PageNavigator(int boardPerPage, int pagePerGroup, int currentPage, int totalRecord) {
		this.boardPerPage = boardPerPage;
		this.pagePerGroup = pagePerGroup;
		this.totalRecord = totalRecord;
		// 전체페이지의 수
		totalPage = (totalRecord + boardPerPage - 1) / boardPerPage;
		// 현재페이지의 조건식
		if (currentPage < 1)
			this.currentPage = 1;
		else if (currentPage > totalPage)
			this.currentPage = totalPage;
		else
			this.currentPage = currentPage;

		// 현재속한그룹 (0부터 시작 가능)
		currentPageGroup = (this.currentPage - 1) / pagePerGroup;
		// 현재 속한 그룹의 첫페이지
		startPageGroup = currentPageGroup * pagePerGroup + 1;
		if (startPageGroup < 1) {
			startPageGroup = 1;
		}
		// 현재 속한 그룹의 끝페이지
		endPageGroup = startPageGroup + pagePerGroup - 1;
		if (endPageGroup > totalPage) {
			endPageGroup = totalPage;
		}
		// 현재 페이지의 첫 게시글 위치
		startBoardPage = (this.currentPage - 1) * boardPerPage;
	}

	public int getBoardPerPage() {
		return boardPerPage;
	}

	public void setBoardPerPage(int boardPerPage) {
		this.boardPerPage = boardPerPage;
	}

	public int getPagePerGroup() {
		return pagePerGroup;
	}

	public void setPagePerGroup(int pagePerGroup) {
		this.pagePerGroup = pagePerGroup;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPageGroup() {
		return currentPageGroup;
	}

	public void setCurrentPageGroup(int currentPageGroup) {
		this.currentPageGroup = currentPageGroup;
	}

	public int getStartPageGroup() {
		return startPageGroup;
	}

	public void setStartPageGroup(int startPageGroup) {
		this.startPageGroup = startPageGroup;
	}

	public int getEndPageGroup() {
		return endPageGroup;
	}

	public void setEndPageGroup(int endPageGroup) {
		this.endPageGroup = endPageGroup;
	}

	public int getStartBoardPage() {
		return startBoardPage;
	}

	public void setStartBoardPage(int startBoardPage) {
		this.startBoardPage = startBoardPage;
	}

	@Override
	public String toString() {
		return "PageNavigator [boardPerPage=" + boardPerPage + ", pagePerGroup=" + pagePerGroup + ", currentPage="
				+ currentPage + ", totalRecord=" + totalRecord + ", totalPage=" + totalPage + ", currentPageGroup="
				+ currentPageGroup + ", startPageGroup=" + startPageGroup + ", endPageGroup=" + endPageGroup
				+ ", startBoardPage=" + startBoardPage + "]";
	}

}