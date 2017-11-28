package persistlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleSequence;

import persistlayer.DbAccessConfiguration;

public class DbAccessImpl {
	
	
	/**
	 * connection 
	 * @return
	 */
	protected static Connection connect() {
		Connection con = null;
		try {
			Class.forName(DbAccessConfiguration.DRIVE_NAME);
			con = DriverManager.getConnection(DbAccessConfiguration.CONNECTION_URL, DbAccessConfiguration.DB_CONNECTION_USERNAME, DbAccessConfiguration.DB_CONNECTION_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	} // end of connect
	/**
	 * retrieves a resultset and returns it
	 * @param query
	 * @return
	 */
	protected static ResultSet retrieve (String query, Connection con) {
		ResultSet rset = null;
		try {
			Statement stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			return rset;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rset;
	}// end of retrieve
	/**
	 * creates a new value in a table
	 * @param sql
	 * @return
	 */
	protected static int create(String sql) {
		Connection c = connect();
		int r = 0;
		try {
			Statement s = c.createStatement();
			r = s.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect(c);
		}
		return r;
	}
	/**
	 * updates values in the table
	 * @param sql
	 * @return
	 */
	protected static int update(String sql){
		Connection c = connect();
		int r = 0;
		try {
			Statement s = c.createStatement();
			r = s.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect(c);
		}
		return r;
	}
	/**
	 * deletes from the table based on the query
	 * @param sql
	 * @return
	 */
	protected static int delete(String sql){
		Connection c = connect();
		int r = 0;
		try {
			Statement s = c.createStatement();
			r = s.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect(c);
		}
		return r;
	}
	/**
	 * disconnects from a connection
	 * @param con
	 */
	protected static void disconnect(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // end of closeConnection
	
	protected static String getString(String sql, String toget) {
		Connection con = connect();
		ResultSet rs = retrieve(sql,con);
		String r = null;
		try {
			if (rs.next())
				r = rs.getString(toget);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		disconnect(con);
		return r;	
	}
	
	protected static int getInt(String sql, String toget){
		Connection c = connect();
		ResultSet rs = retrieve(sql, c);
		int r = 0;
		try {
			if (rs.next())
				r = rs.getInt(toget);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		disconnect(c);
		return r;	
	}
	
	protected static SimpleSequence getSequence(String sql, DefaultObjectWrapperBuilder db){
		Connection c = connect();
		ResultSet rs = retrieve(sql, c);
		SimpleSequence sq = new SimpleSequence(db.build());
		try {
			
				while(rs.next()){
					String temp = rs.getString(1);
					sq.add(temp);
				}
			
			}catch (SQLException e){
				e.printStackTrace();
			}
		
		disconnect(c);
		return sq;
		
	}
	

}

