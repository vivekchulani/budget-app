<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator Confirmation</title>
</head>
<body>


<form action="/BudgetConApplication/AdminBack" method="post">

<div style="margin-top:40px; font-family:serif; font-style: italic;">
<h4 align="center">Budget Allocation for ${Dept } Department</h4>
</div>


<table class="table table-striped table-bordered">

<th>Department</th>
<th>Amount</th>
<th>Date</th>

<tr><td>${Dept }</td><td>${Amt }</td><td>${AllDate }</td></tr>


</table>

<br/>
		<div class="row">
		<div class="col-md-11">
		<div class="col-md-offset-12">
<input type="submit" class="btn btn-primary" value="Back"/>
</div></div></div><br/>

</form>


</body>
</html>