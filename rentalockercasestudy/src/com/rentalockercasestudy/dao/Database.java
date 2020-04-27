package com.rentalockercasestudy.dao;

import java.sql.*;
public class Database {
	
	static Connection con = null;
	
	public static Connection dbconnect() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/RentaLockerCaseStudy", "root", "ZAHIRA11");
			return con;
		}catch(Exception e) {
			e.getMessage();
		}
		return con;
	}
	public static void Close(Connection con, PreparedStatement pst, ResultSet rs) throws SQLException {
		if(con != null) {
			con.close();
		}
		if(pst != null) {
			pst.close();
		}
		if(rs != null) {
			rs.close();
		}
	}
}
