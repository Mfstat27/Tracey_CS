<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<div class="jumbotron text-center">
<jsp:include page="menu.jsp"></jsp:include>

<h2>Please Login</h2>
</div>
<form:form action="profilepage" method="POST" modelAttribute="userLogin">
				<label>Username</label> 
				<form:input type="text" path="userName" id= "userName" value="" placeholder="Enter your email" /> <br><br>
				<form:errors path="userName"/>
				 <label>Password</label> 
				<form:input type="password"  path="password" id = "password" value="" placeholder="Enter your password"  /> <br><br>
				<form:errors path="password"/>
				<label>Remember Me</label> 
				<form:checkbox  path="rememberMe"  id = "checkbox" value="" /> <br><br>
				<form:errors path="rememberMe"/>
				<input type="submit" name="Sign In" value="Sign In" /> <br><br>
				<a href="homeRM"><form:button id="cancel" name="Cancel" value="cancel" /></a><br>
		</form:form>
</body>
</html>