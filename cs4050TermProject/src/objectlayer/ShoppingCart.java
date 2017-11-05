package objectlayer;

public class ShoppingCart {

	private int customerID;
	private double totalPrice;
	
	public int getCustomerID() {
		return customerID;
	}
	
	public double getTotal() {
		return totalPrice;
	}
	
	public void setTotal(double price) {
		this.totalPrice = price;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
}
