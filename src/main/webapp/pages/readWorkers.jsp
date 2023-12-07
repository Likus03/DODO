<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Couriers</title>

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
        <th>NAME</th>
        <th>FAMILY</th>
        <th>phoneNumber</th>
        <th>DELIVERY</th>
        <th>ROLE</th>
    </tr>
    </thead>
    <tbody>
    <form action="/update" method="post">
        <c:forEach var="couriers" items="${workers}">
        <tr>
            <td>${couriers.firstname}</td>
            <td>${couriers.surname}</td>
            <td>${couriers.phoneNumber}</td>
            <td>${couriers.userType}</td>
            <td><input type="radio" id="${couriers.id}" name="radioGroup" value="${couriers.id}"></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<td><input type="submit" name="editCourier" value="delete"></td>
<td><input type="submit" name="editCourier" value="update"></td>
</body>
</html>