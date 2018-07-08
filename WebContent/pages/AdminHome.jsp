<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Administrator Home</title>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" href ="../resources/Folder/css/bootstrap.min.css"/>
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script> 
<script>
  $(function() {
    $(".datepicker").datepicker();
  });
</script>

</head>
<body>


		<div class="container">
	<div class="col-md-offset-4">
	
	<div class="row " >
	</div>
	<div class="col-md-6">
	<div class="panel panel-default">
	
	<div class="panel-heading">Allocate Funds</div>
	
	<div class="panel-body">


	<form name="AdminHomeForm" action="/BudgetConApplication/AdminSubmit" method="post">
	
	
	
	<div class="row" style="margin-top:10px">
	<div class="form-group">
	<div class="col-md-8">
		Amount: <input type="text" placeholder="Enter amount" class="form-control" name="amount" /> 
		<div id="amountErrors" style="color:red"></div>
		</div></div></div>
		<br />
		
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
		</div></div></div>
		<br/>
		
		
			<div class="row">
	<div class="dropdown">
	<div class="col-md-8">
		Date: <br/><input type="text" id="allDate" name="allocationDate" class="datepicker btn btn-default dropdown-toggle" style="text-align:left"/>
		<div id="dateErrors" style="color:red"></div>
		</div></div></div>
		
		<br />
		
				<div class="row">
		<div class="col-md-8">
		<input type="submit" class="btn btn-primary" onclick="return validatorForm()" value="Allocate Funds" />
		</div></div>

	
	</form>
	
	</div></div></div></div></div>
	
	
	<script>
	
	var testamount = /^[0-9]{1,7}$/;
	
		function validatorForm() {
		
		var a = document.forms["AdminHomeForm"]["amount"].value;
			if (!testamount.test(a)) {
				document.getElementById('amountErrors').innerHTML = "Please enter an amount (numeric values only)!";
				return false;
			}

			var d = document.forms["AdminHomeForm"]["department"].value;
			if (d == "None") {
				document.getElementById('deptErrors').innerHTML = "Please select a department!";
				return false;
			}
			
			var dat = document.forms["AdminHomeForm"]["allocationDate"].value;
			if (dat == "" || dat == null) {
				document.getElementById('dateErrors').innerHTML = "Please select date!";
				return false;
			}
		}
	</script>
	
	


</body>
</html>