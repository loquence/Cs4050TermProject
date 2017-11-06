package objectlayer;

public class Manager extends User {

	private static String type = "manager";
	
	public Manager(String fname, String lname, String email, String pwd) {
		super(fname, lname, email, pwd);
	}
	
	public String getType() {
		return type;
	}
	
}
