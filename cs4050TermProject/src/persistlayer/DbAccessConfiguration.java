package persistlayer;

public abstract class DbAccessConfiguration {

	static final String DRIVE_NAME = "com.mysql.jdbc.Driver";
	
	static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/bookstore?verifyServerCertificate=false&useSSL=true";
	
	static final String DB_CONNECTION_USERNAME = "root";
	
	static final String DB_CONNECTION_PASSWORD = "root";
}
