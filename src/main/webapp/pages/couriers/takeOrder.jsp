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
        <th>DESCRIBE</th>
        <th>COST</th>
        <th>ADDRESS</th>
        <th>TIME_DELIVERY</th>
    </tr>
    </thead>
    <tbody>
    <form method="post" action="/takeOrder">
        <c:forEach var="orders" items="${orders}">
            <tr>
                <td>${orders.describe}</td>
                <td>${orders.cost}</td>
                <td>${orders.address}</td>
                <td>${orders.deliveryTime}</td>
                <td><input type="radio" name="id" value="${orders.id}"></td>
                <input type="hidden" name="describe" value="${orders.describe}">
                <input type="hidden" name="cost" value="${orders.cost}">
                <input type="hidden" name="address" value="${orders.address}">
                <input type="hidden" name="deliveryTime" value="${orders.deliveryTime}">
            </tr>
        </c:forEach>
    </tbody>
</table>
<input type="submit" name="takeOrder" value="take">
</form>
<button><a href="/pages/orders/couriersPage.jsp">Back</a></button>
<form action="/logOut" method="get">
    <input style="font-size: 20px" type="submit" value="LogOut">
</form>
</body>
</html>
