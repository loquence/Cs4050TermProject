package objectlayer;
import persistlayer.BookstorePersistImpl;
public class User {
	private String fname;
	private String lname;
	private String email;
	private String pwd;
	private BookstorePersistImpl bookstorePersist;
	public User (String fname, String lname, String email, String pwd) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pwd = pwd;
		bookstorePersist = new BookstorePersistImpl();
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int login() {
		return bookstorePersist.login(this);
	}
	
	public User checkEmail() {
		return bookstorePersist.checkEmail(this.email);
	}
}
