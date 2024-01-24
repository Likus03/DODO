<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Couriers Page</title>
</head>
<body>
<h2>Welcome!</h2>
<form action="/takeOrder" method="get">
    <input type="submit" value="take order">
</form>
<form action="/readCompletedOrders" method="get">
    <input type="submit" value="to completed orders">
</form>
<br><br>
<form action="/completeOrder" method="get">
    <input type="submit" value="complete order">
</form>
<form action="/readSchedule" method="get">
    <input type="submit" value="read schedule">
</form>
<br><br><br><br>
<form action="/logOut" method="get">
    <input style="font-size: 20px" type="submit" value="LogOut">
</form>
</body>
</html>
