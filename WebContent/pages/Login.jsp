<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login</title>
</head>
<body>
	
	<div class="container ">
	<div class="col-md-offset-4">
	
	<div class="row " >
	</div>
	<div class="col-md-6">
	<div class="panel panel-default ">
	
	<div class="panel-heading ">Log In </div>
		
	<div class="panel-body ">
	
	<form name="LoginForm" action="/BudgetConApplication/LoginSubmit"
		method="post">
			
	
	<div class="form-group" style="margin-top:10px">
	<div class="row">
	<div class="col-md-8">

		Username: <input type="text" class="form-control" placeholder="Enter username"  name="username"/><h5 style="color: red">${ERR1 }</h5>
		<div id="userErrors"></div>
		
		</div>
		</div>
		</div>
	
		
		
		<div class="form-group ">
		<div class="row">
		<div class="col-md-8">

		Password: <input type="password" class="form-control" placeholder="Enter password" name="password" /><h5 style="color: red">${ERR }</h5> 
		<div id="passErrors"></div>
		</div>
		</div>
		</div>
		
		<div class="row">
		<div class="col-md-8">

		<input type="submit" value="Enter" class="btn btn-primary" onclick="return validatorForm()" /><br/>
		</div>
		</div>

		
	</form>

	<form action="/BudgetConApplication/RegSubmit" method="post">
	
		<div class="row">
		<div class="col-md-8">
		<br/>
		<input type="submit" class="btn btn-primary" value="Register">
		</div>
		</div>

	
		
	</form>
	
			</div>
		</div>
		</div>
		</div>
		</div>
	

	

	${LogSuccess }
	${Logoff }

	<script>
	
	var testusername1 = /^[A-Za-z0-9 ]{3,20}$/;
	var testpassword1 = /^[A-Za-z0-9 ]{7,20}$/;
	
		function validatorForm() {
			var user = document.forms["LoginForm"]["username"].value;
			if (!testusername1.test(user)){
				document.getElementByIDd('userErrors').innerHTML = "Username must be between 3 to 20 characters!";
				return false;
				}
			var pass = document.forms["LoginForm"]["password"].value;
			if (!testpassword1.test(pass)) {
				document.getElementByIDd('passErrors').innerHTML = "Password must be between 7 to 20 characters!";
				return false;
			}
		}
	</script>

</body>
</html>
