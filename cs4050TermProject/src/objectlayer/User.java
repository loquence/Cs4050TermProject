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
	private UserType type;
	private Status status;
	public User (String fname, String lname, String email, String pwd, Status status, UserType type) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pwd = pwd;
		this.status = status;
		this.type= type;
		bookstorePersist = new BookstorePersistImpl();
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
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
	public int verifyCode(String code) {
		return bookstorePersist.verifyCode(this, code);
	}
	/*
	public int createUser() {		
		return bookstorePersist.addUser(this);
	}
	*/
	
}
