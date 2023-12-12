package handler;

import domain.PagingVO;

//list 하단에 나오는 페이지네이션 핸들링 클래스
public class PagingHandler {
	
	private int startPage; //시작페이지 1/11/21 ...
	private int endPage; //마지막 페이지 10/20/30..
	private int realEndPage; //전체 리스트의 끝번호
	private boolean prev, next; //이전ㄴ, 다음 페이지의 존재 여부
	
	//파라미터로 받기
	private int totalCount; //전체 글 수
	private PagingVO pgvo;
	
	public PagingHandler(PagingVO pgvo, int totalCount) {
		this.pgvo=pgvo; //PagingVO 기본 생성자
		this.totalCount=totalCount; //컨트롤러에서 DB조회 전체 게시글 수
		//페이지 번호를 클릭해도 시작은 1, 끝은 10
		//1/10=>0.1=(올림)1*10 =10
		//2/10=>0.2=(올림)1*10 =10
		//11/10=>1.1=(올림)2*10 =20
		//21/10=>1.1=(올림)3*10 =30
		this.endPage = (int)Math.ceil(pgvo.getPageNo()/(double)pgvo.getQty())*pgvo.getQty();
		this.startPage=this.endPage-9;
		
		//전체 게시글 수 / 한 화면에 게시되는 게시글 수
		//101->101/10 -> 10.1 => (올림)11페이지
		this.realEndPage= (int)Math.ceil(totalCount / (double)pgvo.getQty());

		if(this.realEndPage < this.endPage) {//마지막 페이지 수가 진짜 마지막 페이지랑 다를 때 처리
			this.endPage = this.realEndPage;
		}
		
		this.prev = this.startPage>1;
		this.next = this.endPage<this.realEndPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getRealEndPage() {
		return realEndPage;
	}

	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
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

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public PagingVO getPgvo() {
		return pgvo;
	}

	public void setPgvo(PagingVO pgvo) {
		this.pgvo = pgvo;
	}

	@Override
	public String toString() {
		return "PagingHandler [startPage=" + startPage + ", endPage=" + endPage + ", realEndPage=" + realEndPage
				+ ", prev=" + prev + ", next=" + next + ", totalCount=" + totalCount + ", pgvo=" + pgvo + "]";
	}

	
	
}
