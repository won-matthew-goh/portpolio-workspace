package com.global.moviego.domain;

//페이지 번호, 현재 페이지, 페이지 당 노출 수, 페이지 수
public class PageVO {
	//사용자가 선택한 페이지 정보를 담을 변수.
	private int pageNum; //jsp에 선택된 페이지
	private int currentPage;
	
	private int countPerPage;
	private double pageCnt;
	
	//페이지 기본 null 값 설정
	public PageVO() {
		this.pageNum = 1; //기본 선택 페이지 =1
		this.countPerPage = 10; //페이지당 노출 수 10개
	}
	//start
	public int getPageStart() {
		return (pageNum-1)*countPerPage;
	}
	
	
	//게터, 세터
    public double getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(double pageCnt) {
		this.pageCnt = pageCnt;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}



}
