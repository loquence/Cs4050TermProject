package objectlayer;
import persistlayer.BookstorePersistImpl;
/**
 * User class implenentation
 * @author Ryan
 *
 */
public class User {
	private String fname;
	private String lname;
	private String email;
	private String pwd;
	private BookstorePersistImpl bookstorePersist;
	private Status status;
	public User (String fname, String lname, String email, String pwd, Status status) {
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
	public BookstorePersistImpl getPersist() {
		return bookstorePersist;
	}
	
	public User checkEmail() {
		return bookstorePersist.checkEmail(this.email);
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	/*
	public int createUser() {		
		return bookstorePersist.addUser(this);
	}
	*/
	
}
