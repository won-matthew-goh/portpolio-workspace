package com.global.moviego.domain;

//페이지 번호, 현재 페이지, 페이지 당 노출 수, 페이지 수
public class PageVO {
	private int pageNum = 1;
	private int countPerPage = 10;
	private int total;
	private int offset;

	// getter 및 setter
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
}
