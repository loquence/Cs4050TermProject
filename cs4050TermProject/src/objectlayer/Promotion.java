package objectlayer;
import java.util.Date;	//should this be a Calendar though? Date is deprec.

public class Promotion {
	
	private  String code;
	private double percentage;
	private Date expiration;
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public double getPercentage() {
		return percentage;
	}
	
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	public Date getExpiration() {
		return expiration;
	}
	
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

}
