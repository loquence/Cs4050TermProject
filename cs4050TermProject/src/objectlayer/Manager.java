package objectlayer;

public class Manager extends User {

	private static String type = "manager";
	
	public Manager(String fname, String lname, String email, String pwd, Status status) {
		super(fname, lname, email, pwd, status);
	}
	
	public String getType() {
		return type;
	}
	
}
