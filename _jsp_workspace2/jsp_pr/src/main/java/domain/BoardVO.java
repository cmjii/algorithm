package domain;

public class BoardVO {
	//번호, 제목, 작성자, 날짜, 수정날짜, 조회
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private String moddate;
	private int readcount;
	private String imageFile;
	
	public BoardVO() {}
	
	//insert
	public BoardVO(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	//list
	public BoardVO(int bno, String title, String writer, String regdate, int readcount) {
		this.title = title;
		this.writer = writer;
		this.bno = bno;
		this.regdate = regdate;
		this.readcount = readcount;
	}
	
	//update
	public BoardVO(int bno, String title, String content) {

		this.bno = bno;
		this.title = title;
		this.content = content;
	}
	
	//detail
	public BoardVO(int bno, String title, String writer, String content, String regdate, String moddate,
			int readcount, String imageFile) {

		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.moddate = moddate;
		this.readcount = readcount;
		this.imageFile = imageFile;
	}
	
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getModdate() {
		return moddate;
	}
	public void setModdate(String moddate) {
		this.moddate = moddate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", moddate=" + moddate + ", readcount=" + readcount + ", imageFile=" + imageFile + "]";
	}
	
	
}
