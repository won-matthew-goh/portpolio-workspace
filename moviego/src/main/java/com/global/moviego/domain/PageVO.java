package com.global.moviego.domain;

import java.util.List;

public class PageVO {
	//사용자가 선택한 페이지 정보를 담을 변수.
	private int pageNum;
	private int countPerPage;
	private double pageCnt;
    public int getPageStart() {
	        return (pageNum-1)*countPerPage;
	    }
	
	public PageVO() {
		this.pageNum = 1;
		this.countPerPage = 10;
	}
	
	public ConvertPage() {
		
	}
	
	
	//게터 세터
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

	public double getPagecnt() {
		return pageCnt;
	}

	public void setPagecnt(int pagecnt) {
		this.pageCnt = pagecnt;
	}


}
