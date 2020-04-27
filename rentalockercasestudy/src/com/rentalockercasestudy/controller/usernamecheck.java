package com.rentalockercasestudy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentalockercasestudy.dao.Database;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * Servlet implementation class usernamecheck
 */
@WebServlet("/usernamecheck")
public class usernamecheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	public usernamecheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailUserName = request.getParameter("emailUserName");
		try {
			conn= Database.dbconnect();
			pst = conn.prepareStatement("Select * from User where User = ?");
			pst.setString(1,emailUserName);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("Already Exists");
			}else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("Available");			
				}
		}catch(Exception e) {
			
		}
	}

}
