<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign out</title>
</head>
	<% session.invalidate();%>
<body>
<jsp:include page="menu.jsp"></jsp:include>

	<div>
		<!-- header -->
		<jsp:include page="menu.jsp"></jsp:include>

		<h1>You are signed out</h1>
	</div>
	<div>
<!-- 		body -->


	</div>
	</body>
</html>