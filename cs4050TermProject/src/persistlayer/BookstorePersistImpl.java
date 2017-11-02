package persistlayer;
import objectlayer.*;
/**
 * Class that calls the DbAccessImpl methods to access the database
 * Called by classes in the Object Layer
 * Currently can be called by BookstorelogicImpl but should be removed in
 * future versions
 * @author Ryan
 *
 */
public class BookstorePersistImpl {
	/**
	 * create customer object in database
	 * @param u
	 * @return
	 */
	public int addCustomer(Customer u) {
		String sql = "INSERT INTO users (fname,lname,email,password,type,verified) VALUES" + "('"+u.getFname()+"','"+u.getLname()+"','"+ u.getEmail() + "','"+ u.getPwd() +"','"+u.getType() +"','"+u.getVerified()+"');" ;
		return DbAccessImpl.create(sql);
	}
	
	/**
	 * login a user 
	 * in the future, this should return the type to allow for 
	 * the server to differentiate between each type of user
	 * @param u
	 * @return
	 */
	public int login(User u) {
		String email = u.getEmail();
		String pwd = u.getPwd();
		String sql = "SELECT password FROM users WHERE email=\"" + email + "\";";
		String sql2 = "SELECT id FROM users WHERE email=\"" + email + "\";";
		String p = DbAccessImpl.getString(sql, "password");
		if (pwd.equals(p)) {
			return DbAccessImpl.getInt(sql2, "id");
		}
		return -1;
	}
	
	/**
	 * SQL query called when checking if the email is available
	 * @param email
	 * @return
	 */
	public User checkEmail(String email){
		String sql ="SELECT * FROM users WHERE email=\'" + email + "\';";
		return new User("","", DbAccessImpl.getString(sql,"email"),"");
	}
}
