package objectlayer;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleSequence;
public class Admin extends User {

	
	
	public Admin(String fname, String lname, String email, String pwd, Status status) {
		super(fname, lname, email, pwd, status, UserType.ADMIN);
	}
	
	public SimpleSequence getUsers(DefaultObjectWrapperBuilder db) {
		return getPersist().getUsers(db);
	}
	
	
}
