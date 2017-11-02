package objectlayer;
/**
 * Customer class implementation
 * @author Ryan
 *
 */
public class Customer extends User {
	private static String type = "customer";
	private String address;
	private String number;
	private int verified;
	public Customer(String fname, String lname, String email, String pwd, int verified) {
		super(fname, lname, email, pwd);
		this.verified = verified;
		// TODO Auto-generated constructor stub
	}
	
	public String getType() {
		return type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getVerified() {
		return verified;
	}

	public void setVerified(int verified) {
		this.verified = verified;
	}

	
}
