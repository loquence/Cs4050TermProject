package objectlayer;

public class ShipmentEmployee extends User {

	private static String type = "shipment_employee";
	
	public ShipmentEmployee(String fname, String lname, String email, String pwd, Status status) {
		super(fname, lname, email, pwd, status);
	}
	
	public String getType() {
		return type;
	}
	
}
