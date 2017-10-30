package persistlayer;
import objectlayer.*;
public class BookstorePersistImpl {
	public int addCustomer(Customer u) {
		String sql = "INSERT INTO users (name,email,password,type) VALUES" + "('"+u.getFname()+"','"+ u.getEmail() + "','"+ u.getPwd() +"','"+u.getType() +"');" ;
		return DbAccessImpl.create(sql);
	}
	
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
	
	public String checkEmail(String email){
		String sql ="SELECT email FROM users WHERE email=\'" + email + "\';";
		return DbAccessImpl.getString(sql,"email");
	}
}
