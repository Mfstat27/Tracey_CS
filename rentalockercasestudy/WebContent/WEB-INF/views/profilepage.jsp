<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  page import="com.rentalockercasestudy.models.User" %>
    <%@  page import="com.rentalockercasestudy.services.UserServices" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyProfilePage</title>
</head>
<body>
<%
User u = (User)session.getAttribute("userSession");
session.setAttribute("userSession", u);
%>

<div class="jumbotron text-center">
<jsp:include page="menu.jsp"></jsp:include>
<h1 style="padding-top:100px">
Profile Page
</h1>

<h2>Hi, ${userSession.getUserNameEmail()}</h2>

</div>
</body>

</html>