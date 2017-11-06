package objectlayer;

public class Admin extends User {

	private static String type = "admin";
	
	public Admin(String fname, String lname, String email, String pwd) {
		super(fname, lname, email, pwd);
	}
	
	public String getType() {
		return type;
	}
}
