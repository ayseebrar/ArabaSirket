package Model;

public class User {
	 private int id;
	 String tcno,password,type,name;
	protected User(int id, String tcno, String password, String type, String name) {
		super();
		this.id = id;
		this.tcno = tcno;
		this.password = password;
		this.type = type;
		this.name = name;
	}
	public User() {}
	protected int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTcno() {
		return tcno;
	}
	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	public  String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public  String getName() {
		return name;
	}
	public  void setName(String name) {
		this.name = name;
	}
}
