<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@  page import="com.rentalockercasestudy.models.User" %>
    <%@  page import="com.rentalockercasestudy.services.UserServices" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Login</title>
</head>
<body>

<div class="jumbotron text-center">
<jsp:include page="menu.jsp"></jsp:include>
<h2 class = "display-3" style="padding-top:150px">Please Login</h2>
</div>
<form:form action="signInRM" method="get" modelAttribute="userSession" class="needs-validation" novalidate="">
				<div class="row" style="padding-left:520px">
      			<div class="col-md-6">
				<div class="form-group">
     			 <label for="userNameEmail">Username:</label>
				<form:input type="email" name = "userNameEmail" class="form-control"  path="userNameEmail" id= "userNameEmail" value="" placeholder="Enter your email" /> <br>
				<div class="valid-feedback"></div>
      			<div class="invalid-feedback">Please fill out this field.</div>
				<form:errors path="userNameEmail"/>
				</div>
				</div>
    			</div>
    			<div class="row" style="padding-left:520px">
      			<div class="col-md-6">
				 <div class="form-group">
     			 <label for="password">Password:</label>
					<form:input type="password"  class="form-control" name = "password" path="password" id = "password" value="" placeholder="Enter your password"  /> <br><br>
					<div class="valid-feedback"></div>
      				<div class="invalid-feedback">Please fill out this field.</div>
				<form:errors path="password"/>
				</div>
				</div>
				  </div>
				<input type="submit" class ="btn btn-primary" name="Sign In" value="Sign In" style="margin-left:520px;background:gray; border: solid gray"/> &nbsp;&nbsp;&nbsp;&nbsp; 
				<a href="homeRM"><button id="cancel" class ="btn btn-primary" name="Cancel" value="cancel" style="background:red; border: solid red">Cancel</button></a><br>
		</form:form>
		
		
		
		<script>
// Disable form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Get the forms we want to add validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>
<br><br><br>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>