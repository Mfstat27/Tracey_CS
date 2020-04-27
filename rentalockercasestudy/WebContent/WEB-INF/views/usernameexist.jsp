<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.rentalockercasestudy.services.UserServices"%>
<%@page import="com.rentalockercasestudy.models.User"%>
<%@page import="com.rentalockercasestudy.controller.usernamecheck" %>

<%

Class.forName("org.mariadb.jdbc.Driver");
Connection con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/RentaLockerCaseStudy", "root", "ZAHIRA11");
    PreparedStatement ps = con.prepareStatement("SELECT  * FROM user WHERE " +
            "USERNAMEEMAIL = ?");
	ps.setString(1, "tracey_thomas@live.com");
    ResultSet res = ps.executeQuery();
    System.out.println(res.getString("USERNAMEEMAIL"));
    System.out.println(res.first());
            if(res.first()){
                out.print("User already exists");
            }else{
                out.print("User name is available");
            }
        
%>
