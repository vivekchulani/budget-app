<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/Folder/css/bootstrap.min.css">

<title><tiles:getAsString name="title"/></title>

</head>
<body>

<table cellpadding="1" cellspacing="1" align="center" style="width: 1000px; ">
    <tr>
    
        <td height="30" colspan="1"><tiles:insertAttribute name="header" /></td>
    </tr>
    <tr>
        <td height="15"><tiles:insertAttribute name="menu" /></td></tr>
        
        <tr><td><tiles:insertAttribute name="body" /></td>
    </tr>
    <tr></tr>
    <tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>
