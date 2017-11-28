package objectlayer;

public class Manager extends User {

	
	
	public Manager(String fname, String lname, String email, String pwd, Status status) {
		super(fname, lname, email, pwd, status, UserType.MANAGER);
	}
	
	
	
}
