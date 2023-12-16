<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h3>SingUp failed</h3>
<form action="/logOut" method="get">
    <input style="font-size: 20px" type="submit" value="LogOut">
</form>
<form action="/pages/admin/admin.jsp" method="post">
    <input type="submit" name="buttonBack" value="back">
</form>
</body>
</html>
