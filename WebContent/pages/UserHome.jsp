<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>User Home</title>

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
	
	<div class="panel-heading">Submit Expenditure</div>
	
	<div class="panel-body">

<form name="UserHomeForm" action="/BudgetConApplication/UserSubmit" method="post">

			<div class="row" style="margin-top:10px">
			<div class="dropdown">
			<div class="col-md-8">
Expense Type: <select name="expense" class="btn btn-default dropdown-toggle" style="text-align:left">
				<option value="None">Select Expense Type</option>
				<option value="Deduct">Deduct</option>
				<option value="Credit">Credit</option>
				</select>
				<div id="expTErrors" style="color:red"></div>
				</div></div></div>
				<br/>
				
	<div class="form-group">
	<div class="row">
	<div class="col-md-8">
Amount: <input type="text" class="form-control" placeholder="Enter amount" name="amount"/>
<div id="amountErrors" style="color:red"></div>
	</div>
	</div>
	</div>

	<br/>

	<div class="row">
	<div class="dropdown">
	<div class="col-md-8">
Payment Date: <br/><input type="text" id="expDate" name="expenseDate" class="datepicker btn btn-default dropdown-toggle" style="text-align:left"/><br/>
<div id="payDErrors" style="color:red"></div>
</div></div></div>

<br/>
	<div class="row">
	<div class="col-md-8">
<input type="submit" value="Submit Expenditure" class="btn btn-primary	" onclick="return validatorForm()"/>
</div></div>


</form>

</div></div></div></div></div>

	<script>
	
	var testamount = /^[0-9]{1,7}$/;
	
		function validatorForm() {

			var d = document.forms["UserHomeForm"]["expense"].value;
			if (d == "None") {
				document.getElementById('expTErrors').innerHTML = "Please select an expense type!";
				return false;
			}
			
			var a = document.forms["UserHomeForm"]["amount"].value;
			if (!testamount.test(a)) {
				document.getElementById('amountErrors').innerHTML = "Please enter an amount (numeric values only)!";
				return false;
			}
			
			var dat = document.forms["UserHomeForm"]["expenseDate"].value;
			if (dat == "" || dat == null) {
				document.getElementById('payDErrors').innerHTML = "Please select payment date!";
				return false;
			}
		}
	</script>


</body>
</html>		
