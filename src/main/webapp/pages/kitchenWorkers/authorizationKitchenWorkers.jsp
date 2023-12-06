<%--
  Created by IntelliJ IDEA.
  User: lika_piv
  Date: 05.12.2023
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization Kitchen Worker</title>
</head>
<body>
<form action="/kitchenWorkers/authorization" method="post">
    <input type="text" name="login" placeholder="put your login">
    <input type="text" name="password" placeholder="put your password">
    <input type="submit" name="buttonAuthorization" value="log in">
</form>
</body>
</html>
