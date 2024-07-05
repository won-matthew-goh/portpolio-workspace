package com.global.moviego.domain;

public class PageCreate {

	private PageVO paging;
	private int articleTotalCount;
	private int endPage;
	private int beginPage;
	private boolean prev;
	private boolean next;
	
	private final int buttonNum = 10; //버튼은 10개 노출로 고정
	
	
	private void calcDataOfPage() {
		//화면에서 보여지는 제일 끝번호(소수점으로 만들어서 올림처리, 10, 20, 30...)
		endPage = (int) (Math.ceil(paging.getPageNum() / (double)buttonNum ) * buttonNum);
		//화면에서 보여지는 제일 첫번째 번호
		beginPage = (endPage - buttonNum) + 1;
		//시작페이지 1이면 그 전번호 없음 false
		prev = (beginPage == 1) ? false : true;
		//DB 저장된 데이터 수 <= 끝페이지*페이당 글 수(우리는 10) 같으면 false 반환해서 next 동작 X
		next = articleTotalCount <= (endPage * paging.getCountPerPage()) ? false : true;
		//만약 next가 true 이면 endPage를 새로 계산 해주어야 함. 102/10 = 10.2 -> 11 이 endpage
		if(!next) {
			endPage = (int) Math.ceil(articleTotalCount / (double) paging.getCountPerPage()); 
		}
		
	}
	//DB에 저장된 전체 게시글 수 받아 넣고, 데이터들 계산하는 메소드 실행
	public void setArticleTotalCount(int articleTotalCount) {
		this.articleTotalCount = articleTotalCount;
		calcDataOfPage();
	}

	
	//게터, 세터
	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getArticleTotalCount() {
		return articleTotalCount;
	}

	public int getButtonNum() {
		return buttonNum;
	}

	public PageVO getPaging() {
		return paging;
	}

	public void setPaging(PageVO paging) {
		this.paging = paging;
	}
	
	
}
