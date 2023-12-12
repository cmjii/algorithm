package domain;

public class MemberVO {

//	create table member(
//	id varchar(100),
//	pwd varchar(200) not null,
//	email varchar(200) not null,
//	age int default 0,
//	regdate datetime default now(),
//	lastlogin datetime default now(),
//	primary key(id));
	
	private String id;
	private String pwd;
	private String email;
	private int age;
	private String regdate;
	private String lastlogin;
	

	public MemberVO() {}
	//login : id, pwd
	public MemberVO(String id, String pwd) {
		this.id=id;
		this.pwd = pwd;
	}
	
	
	//join, modify (날짜 빼고 전부 다)
	public MemberVO(String id, String pwd,String email, int age) {
		this(id,pwd);
		this.email=email;
		this.age=age;
	}
	
	
	public MemberVO(String id, String pwd,String email, int age, String regdate, String lastlogin) {
		this(id,pwd);
		this.email=email;
		this.age=age;
		this.regdate=regdate;
		this.lastlogin=lastlogin;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}
	@Override
	public String toString() {
		return "id:" + id + ", pw:" + pwd + ", email:" + email + ", age:" + age + ", regdate:" + regdate
				+ ", lastlogin:" + lastlogin + "]";
	}
	

	
}
