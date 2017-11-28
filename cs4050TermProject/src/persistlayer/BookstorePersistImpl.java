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
	public int addUser(Customer u) {
		String sql = "INSERT INTO users (fname,lname,email,password,type,status) VALUES" + "('"+u.getFname()+"','"+u.getLname()+"','"+ u.getEmail() + "','"+ u.getPwd() +"','"+u.getType() +"','"+u.getStatus()+"');" ;
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
		String sql = "SELECT * FROM users WHERE email=\"" + email + "\";";
		String sql2 = "SELECT * FROM users WHERE email=\"" + email + "\";";
		String p = DbAccessImpl.getString(sql, "password");
		if(p != null) {
			if (pwd.equals(p)) {
				return DbAccessImpl.getInt(sql, "id");
			}
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
		return new Customer("","", DbAccessImpl.getString(sql,"email"),"",Status.VERIFIED);
	}
	public int addCode(Customer u, String code) {
		String sql = "INSERT into user_verification_code (email,code) VALUES" +"('"+ u.getEmail() +"','"+ code+ "');" ;
		return DbAccessImpl.create(sql);
	
	}
	public int checkCode(String code) {
		String sql ="SELECT * from user_verification_code WHERE code=\'" + code +"\';";
		String cd = DbAccessImpl.getString(sql, "code");
		if (cd != null)
			return -1;
		return 1;
	}
	
	public int verifyCode(String email, String code) {
		String sql = "SELECT * FROM user_verification_code WHERE email=\'" + email + "\';";
		
		String p = DbAccessImpl.getString(sql,"code");
		if(p != null) {
			return 1;
		}
		return -1;
	}
}
