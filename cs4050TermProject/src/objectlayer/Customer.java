package objectlayer;

import persistlayer.BookstorePersistImpl;

/**
 * Customer class implementation
 * @author Ryan
 *
 */
public class Customer extends User {
	
	
	private String address;
	private String number;
	
	public Customer(String fname, String lname, String email, String pwd, Status status) {
		super(fname, lname, email, pwd, status, UserType.CUSTOMER);
		
		
		// TODO Auto-generated constructor stub
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

	public int createUser() {
		return getPersist().addUser(this);
	}
	public int addCode(String code) {
		return getPersist().addCode(this,code);
	}

	
}
