package persistlayer;
import objectlayer.*;
public class BookstorePersistImpl {
	public int addUser(User u) {
		String sql = "INSERT INTO users (username,email,password) VALUES" + "('" + u.getUsername()+ "','"+ u.getEmail() + "','"+ u.getPwd() + "');" ;
		return DbAccessImpl.create(sql);
	}
	
	public int login(String email, String pwd) {
		String sql = "SELECT password FROM users WHERE email=\"" + email + "\";";
		String sql2 = "SELECT id FROM users WHERE email=\"" + email + "\";";
		String p = DbAccessImpl.getString(sql, "password");
		if (pwd.equals(p)) {
			return DbAccessImpl.getInt(sql2, "id");
		}
		return -1;
	}
}
