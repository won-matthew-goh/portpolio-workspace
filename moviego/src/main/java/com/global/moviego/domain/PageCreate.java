package com.global.moviego.domain;

public class PageCreate {
    private int beginPage;
    private int endPage;
    private boolean prev, next;
    private int total;
    private PageVO vo;
    private final int buttonNum = 10; // 버튼은 10개 노출로 고정

    public PageCreate(int total, PageVO vo) {
        this.total = total;
        this.vo = vo;
        calcDataOfPage();
    }
    
    public PageCreate() {
    	
    }

    private void calcDataOfPage() {
        // 화면에서 보여지는 제일 끝 번호 (10, 20, 30...)
        this.endPage = (int) (Math.ceil(vo.getPageNum() / (double) buttonNum) * buttonNum);
        // 화면에서 보여지는 제일 첫 번째 번호
        this.beginPage = this.endPage - buttonNum + 1;
        // 시작 페이지가 1이면 이전 번호 없음
        this.prev = this.beginPage > 1;
        // 총 페이지 수 계산
        int realEnd = (int) (Math.ceil(total * 1.0 / vo.getCountPerPage()));
        // 마지막 페이지가 총 페이지 수보다 크면 수정
        if (this.endPage > realEnd) {
            this.endPage = realEnd;
        }
        // 다음 페이지 여부
        this.next = this.endPage < realEnd;
    }

    // getter 및 setter
    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public PageVO getVo() {
        return vo;
    }

    public void setVo(PageVO vo) {
        this.vo = vo;
    }

    public int getButtonNum() {
        return buttonNum;
    }
}