<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.rentalockercasestudy.models.User,com.rentalockercasestudy.dao.UserDao,com.rentalockercasestudy.services.UserServices" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
<head>
  <title>Registration page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<style>
input {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
}

/* Style the submit button */
input[type=submit] {
  background-color: #4CAF50;
  color: white;
}

/* Style the container for inputs */
/* .container {
  background-color: #f1f1f1;
  padding: 20px;
} */


#message {
  display:none;
  background: #f1f1f1;
  color: #000;
  position: relative;
  padding: 20px;
  margin-top: 10px;
}

#message p {
  padding: 10px 35px;
  font-size: 18px;
}

/* Add a green text color and a checkmark when the requirements are right */
.valid {
  color: green;
}

.valid:before {
  position: relative;
  left: -35px;
  content: "✔";
}

/* Add a red text color and an "x" when the requirements are wrong */
.invalid {
  color: red;
}

.invalid:before {
  position: relative;
  left: -35px;
  content: "✖";
}
</style>

</head>
<body>
<div>
<%@ include file="menu.jsp"%>
</div>

<div class="container"  style="padding-top:300px">
  <h2>Register for a Rent-A-Locker Account</h2>
  <form action="registration" onsubmit="return validateForm()" method="post" name = "regform" >
   <div class="row">
      <div class="col-md-6">
        <input type="text" class="form-control" id="firstName" placeholder="Enter Firstname" name="firstName" required> &nbsp;
      </div>
      <div class="col-md-6">
        <input type="text" class="form-control" id="lastName" placeholder="Enter Lastname" name="lastName" required>
      </div>
    </div>
    <div class="row">
      <div class="col">
        <input type="email" class="form-control" id="emailUserName"  onblur= "checkExist()"value = "" placeholder="Enter username (your email)" name="userNameEmail" required><span id="result"></span>
      </div>

      </div>
        <div class="row">
      <div class="col">
       
          <i class="fas fa-lock prefix"></i>
             <input type="password" id= "pswd"  placeholder="Enter password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
              title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"required>
        </div>
      </div>
        <div class="row">
      <div class="col">
       
          <i class="fas fa-lock prefix"></i>
             <input type="password" id= "pswd2"   placeholder="Please Re-enter password" name="confirm_password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
               title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"required>

        </div>
      </div>
   
    <button type="submit" class="btn btn-primary mt-3" style="background: gray; border: solid gray" onclick="return Validate()">Register</button> &nbsp;&nbsp;&nbsp;&nbsp;
    <button type= "reset" class="btn btn-primary mt-3" style="border: solid rgb(39,122,245)" >Reset</button>&nbsp;&nbsp;&nbsp;&nbsp;
   <a href= "home"><button type= "button" class="btn btn-primary mt-3" style="background: red; border: solid red" >Cancel</button></a>
     </form>
     <div>Meant to <a href = "loginRM"> Login</a>?</div>
</div>
   <div id="message">
  <h3>Password must contain the following:</h3>
  <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
  <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
  <p id="number" class="invalid">A <b>number</b></p>
  <p id="length" class="invalid">Minimum <b>8 characters</b></p>
</div>



  <script>
var myInput = document.getElementById("pswd");
var myInputTwo = document.getElementById("pswd2");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
  document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
 
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
 
  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }

}
</script>
<script type="text/javascript">
    function Validate() {
        var password = document.getElementById("pswd").value;
        var confirmPassword = document.getElementById("pswd2").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
</script>
<script>
 function checkExist(){
    var xmlhttp = new XMLHttpRequest();
  var username = document.forms["regform"]["userNameEmail"].value;
  var url = "usernameexist.jsp" + username;
 xmlhttp.onreadystatechange = function(){
   if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
     if(xmlhttp.responseText == "\n\n\n\n\nUser already exists")
      document.getElementById("result").style.color = "red";
  else
      document.getElementById("result").style.color = "green";
   document.getElementById("result").innerHTML = xmlhttp.responseText;
 }
        
  };
    try{
   xmlhttp.open("POST",url,true);
  xmlhttp.send(null);
 }catch(e){alert("unable to connect to server");
}
 }
</script> 

<!-- <script>
function userNameTaken() {
  alert("Sorry that user name is taken \n please try again");
}
</script> -->
<!-- // /*   pswd.onchange = validatePassword;
//   pswd2.onchange = validatePassword;
//  */ -->


<br><br><br><br><br><br><br><br><br>
<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>