package edu.nf.ViPoPhone.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.nf.ViPoPhone.exception.DaoException;



public class ConnUtils {
	private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url="jdbc:sqlserver://localhost:1433;database=ViPo";
	private static String user="sa";
	private static String pwd="sa";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			
			throw new DaoException(e.getMessage());
		}
	}
	
	public static void close(Connection con,PreparedStatement ps,ResultSet rs) {
		try {
			con.close();
		} catch (SQLException e) {

			throw new DaoException(e.getMessage());
		}
		try {
			ps.close();
		} catch (SQLException e) {

			throw new DaoException(e.getMessage());
		}
		try {
			rs.close();
		} catch (SQLException e) {

			throw new DaoException(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
