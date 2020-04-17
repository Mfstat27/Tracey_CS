<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.rentalockercasestudy.models.User,com.rentalockercasestudy.dao.UserDao,com.rentalockercasestudy.services.UserServices" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <title>Registration page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div>
<%@ include file="menu.jsp"%>
</div>

<div class="container" style="padding-top:300px">
  <h2>Register for a Rent-A-Locker Account</h2>
  <form action="registration" method="get">
   <div class="row">
      <div class="col">
        <input type="text" class="form-control" id="firstName" placeholder="Enter Firstname" name="firstName" required> &nbsp;
      </div>
      <div class="col">
        <input type="text" class="form-control" id="lastName" placeholder="Enter Lastname" name="lastName" required>
      </div>
    </div>
    <div class="row">
      <div class="col">
        <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" required>
      </div>
      <div class="col">
        <input type="password" class="form-control" placeholder="Enter password" name="pswd" required>
      </div>
    </div>
    <br>
    <div class="row">
        <div class="col">
        <label>Please Re-enter your password</label>
        <input type="password" class="form-control" placeholder="Re-Enter password" name="pswd" required>
      </div>
      </div>
    <button type="submit" class="btn btn-primary mt-3" style="background: gray">Submit</button> &nbsp;&nbsp;&nbsp;&nbsp;
    <button type= "button" class="btn btn-primary mt-3" style="backgroun: red">Cancel</button>
  </form>
</div>
<br><br><br><br><br><br><br><br><br>
<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>