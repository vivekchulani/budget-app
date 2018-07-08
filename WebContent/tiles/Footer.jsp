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
<div style="border-left: medium;border-left-width: medium;border-left-style: solid;border-top: medium;border-top-style: solid;border-top-width: medium;border-right: medium;border-right-style: solid;border-top-width: medium;">
<form action="/BudgetConApplication/CurrencySubmit" method="post">
			
			<div class="row">
			<div class="col-sm-2"></div>
			<div class="dropdown col-md-4"><br/>
Currency From: <select name="fromCurrency" class="btn btn-default dropdown-toggle" style="text-align:left">
<c:forEach items="${mapCurrency }" var="get">
<option value="${get.key }"> <c:out value="${get.value }"></c:out>  </option>
</c:forEach>
</select>
</div>


			<div class="dropdown col-md-4"><br/>
Currency To: <select name="toCurrency" class="btn btn-default dropdown-toggle" style="text-align:left">
<c:forEach items="${mapCurrency }" var="get">
<option value="${get.key }"> <c:out value="${get.value }"></c:out>  </option>
</c:forEach>
</select>
</div>

<br/>
<input type="submit" class="btn btn-primary" value="Convert"/>


</div>



</form>

<br/>
<div class="col-md-6 col-md-offset-5" style="font-weight: bold;">

${set }
</div>

</div>
</body>
</html>