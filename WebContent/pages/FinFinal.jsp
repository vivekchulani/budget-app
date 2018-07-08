<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div style="margin-top:40px; font-family:serif; font-style: italic;">
<h4 align="center">Report from ${sDate } to ${eDate }</h4>
</div>

<table class="table table-striped table-bordered">

<th>Expense Date</th>
<th>Expense Type</th>
<th>Expense Amount</th>
<th>Department</th>

<c:forEach items="${expend }" var="get">
<tr><td><c:out value="${get.expenseDate}"></c:out></td>
<td><c:out value="${get.expenseType}"></c:out></td>
<td><c:out value="${get.expense}"></c:out></td>
<td><c:out value="${get.departmentJoinTwo.department}"></c:out></td></tr>

</c:forEach>

<c:forEach items="${all }" var="gett">
<tr><td><b><i>Budget Allocated -  <c:out value="${gett.amount }"/> </i></b><tr><td>
<tr><td><b><i>Budget Remaining - <c:out value="${gett.amountDuplicate }"/> </i></b><tr><td>
</c:forEach>
</table>

	<form action="/BudgetConApplication/FinBack" method="post">
	
		<div class="container">
		
		<div class="row">
		<div class="col-md-11">
		<div class="col-md-offset-12">
		<input type="submit" class="btn btn-primary" value="Back">
		</div>
		</div>
		</div><br/>
		
		</div>
		
	</form>

</body>
</html>