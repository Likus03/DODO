<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ORDERS</title>

    <style type="text/css">
        th {
            color: lightblue;
            font-family: Arial
        }
    </style>

</head>
<body>
<table width="50%" border="1" rules="all">
    <thead>
    <tr>
        <th>IdOrder</th>
        <th>DESCRIBE</th>
        <th>COST</th>
        <th>ADDRESS</th>
        <th>TIME_DELIVERY</th>
    </tr>
    </thead>
    <tbody>
    <form method="post" action="/readOrders">
        <c:forEach var="orders" items="${orders}">
        <tr>
            <td>${orders.idOrder}</td>
            <td>${orders.describe}</td>
            <td>${orders.cost}</td>
            <td>${orders.address}</td>
            <td>${orders.deliveryTime}</td>
        </tr>
        </c:forEach>
    </form>
    </tbody>
</table>
<button><a href="/pages/orders/couriersPage.jsp">Back</a></button>
<form action="/logOut" method="get">
    <input style="font-size: 20px" type="submit" value="LogOut">
</form>
</body>
</html>
