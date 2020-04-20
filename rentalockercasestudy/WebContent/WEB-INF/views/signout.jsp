<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<%@ page import= "" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign out</title>
</head>
	<% session.invalidate();%>
<body>

	<div>
		<!-- header -->
		<jsp:include page="menu.jsp"></jsp:include>

		<h1>You are signed out</h1>
	</div>
	<div>
<!-- 		body -->


	</div>

<!-- lookup! allow values mysql  -->
<!-- lookup! bcrypt -->

	<div>
<!-- 	footer -->
	</div>

</body>
</html>