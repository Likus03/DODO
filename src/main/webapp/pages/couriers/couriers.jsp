<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Couriers</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>NAME</th>
        <th>FAMILY</th>
        <th>phoneNumber</th>
        <th>DELIVERY</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="couriers" items="${couriers}">
        <tr>
            <td>${couriers.firstname}</td>
            <td>${couriers.surname}</td>
            <td>${couriers.phoneNumber}</td>
            <td>${couriers.deliveryType}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
