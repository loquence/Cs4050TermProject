package objectlayer;

public class ShipmentEmployee extends User {

	
	
	public ShipmentEmployee(String fname, String lname, String email, String pwd, Status status) {
		super(fname, lname, email, pwd, status, UserType.SHIP);
	}
	
	
}
