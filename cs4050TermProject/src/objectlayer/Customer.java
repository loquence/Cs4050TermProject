package objectlayer;

public class Customer extends User {
	private static String type = "customer";
	private String address;
	private String number;
	public Customer(String fname, String lname, String email, String pwd) {
		super(fname, lname, email, pwd);
		// TODO Auto-generated constructor stub
	}
	
	public String getType() {
		return type;
	}
}
