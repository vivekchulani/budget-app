<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Register</title>
</head>
<body>
	
	<div class="container">
	<div class="col-md-offset-4">
	
	<div class="row " >
	</div>
	<div class="col-md-6">
	<div class="panel panel-default">
	
	<div class="panel-heading">Registration </div>
	
	<div class="panel-body">
	
	<form name="RegisterForm" action="/BudgetConApplication/RegisterSubmit"
		method="post">
		
		
		
		
		<div class="form-group" style="margin-top:10px">
		<div class="row">
		<div class="col-md-8">
		
		Username: <input type="text" class="form-control" placeholder="Enter username" name="username" /> 
		<div id="userErrors" style="color:red"><h5>${userError }</h5></div>
		</div>
		</div>
		</div>
		
		<div class="form-group">
		<div class="row">
		<div class="col-md-8">
		Password: <input type="password" class="form-control" placeholder="Enter password" name="password" />
		<div id="passErrors" style="color:red"></div>
		</div>
		</div>
		</div>

		
		<div class="form-group">
		<div class="row">
		<div class="col-md-8">
		Email: <input type="text" class="form-control" placeholder="Enter email" name="email" />
		<div id="emailErrors" style="color:red"></div>  
		</div>
		</div>
		</div>
		
		
		<div class="form-group">
		<div class="row">
		<div class="col-md-8">
		EmployeeID: <input type="text" class="form-control" placeholder="Enter Employee ID" name="employeeID" /> 
		<div id="eidErrors" style="color:red"></div>
		</div>
		</div>
		</div>

			
			<div class="row">
			<div class="dropdown">
			<div class="col-md-8">
			Department: <select name="department" class="btn btn-default dropdown-toggle" style="text-align:left">
			<option value="None">Select Department</option>
			<option value="Human Resources"> ${first } </option>
			<option value="Engineering"> ${second }</option>
			<option value="Research and Development">${third }</option>
			<option value="IT">${fourth }</option>
			<option value="Marketing">${fifth }</option>
			<option value="Purchasing">${sixth }</option>
			<option value="Accounting">${seventh }</option>
			<option value="Other">${eigth }</option>
		</select> 
		
		<div id="deptErrors" style="color:red"></div>
		</div>
		</div>
		</div>

			<br/><br/>
			<div class="row">
			<div class="col-md-8">
		 <input type="submit" class="btn btn-primary" onclick="return validatorForm()" value="Register" />
			
			</div>
			</div>
	
	</form>
	
			</div>
			</div>
			</div>
			</div>
			</div>

	<script>
	
	var testusername = /^[A-Za-z0-9 ]{3,20}$/;
	var testpassword = /^[A-Za-z0-9 ]{7,20}$/;
	var testemail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
	var testempid = /^[0-9]{4,4}$/;
	
		function validatorForm() {
		
			var u = document.forms["RegisterForm"]["username"].value;
			if (!testusername.test(u)){
				document.getElementById('userErrors').innerHTML = "Username must be between 3 to 20 characters!";
				return false;
				}
				
			var p = document.forms["RegisterForm"]["password"].value;
			if (!testpassword.test(p)) {
				document.getElementById('passErrors').innerHTML = "Password must be between 7 to 20 characters";
				return false;
			}
			
			var e = document.forms["RegisterForm"]["email"].value;
			if (!testemail.test(e)) {
				document.getElementById('emailErrors').innerHTML = "Please enter valid email!";
				return false;
			}
			var eid = document.forms["RegisterForm"]["employeeID"].value;
			if (!testempid.test(eid)) {
				document.getElementById('eidErrors').innerHTML = "Employee ID can only be FOUR DIGITS!";
				return false;
			}
			var d = document.forms["RegisterForm"]["department"].value;
			if (d == "None") {
				document.getElementById('deptErrors').innerHTML = "Please select a department!";
				return false;
			}
		}
	</script>

</body>
</html>