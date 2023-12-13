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
        <c:forEach var="workers" items="${workers}">
        <tr>
            <td>${workers.firstname}</td>
            <td>${workers.surname}</td>
            <td>${workers.phoneNumber}</td>
            <td>${workers.userType}</td>
            <td><input type="radio" id="${workers.id}" name="radioGroup" value="${workers.id}"></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<%--<td><input type="submit" name="editCourier" value="delete"></td>--%>
<%--<td><input type="submit" name="editCourier" value="update"></td>--%>
</body>
</html>
