package objectlayer;

public class Admin extends User {

	private static String type = "admin";
	
	public Admin(String fname, String lname, String email, String pwd, Status status) {
		super(fname, lname, email, pwd, status);
	}
	
	public String getType() {
		return type;
	}
}
