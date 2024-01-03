<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADMIN</title>
</head>
<body>
<h1 style="text-align: center">ADMIN</h1>

<form action="/create" method="get">
    <input type="submit" value="create">
</form>
<form action="/read" method="get">
    <input type="submit" value="read">
</form>
<form action="/update" method="get">
    <input type="submit" value="update">
</form>
<form action="/delete" method="get">
    <input type="submit" value="delete">
</form>
<form action="/logOut" method="get">
    <input style="font-size: 20px" type="submit" value="LogOut">
</form>
</body>
</html>
