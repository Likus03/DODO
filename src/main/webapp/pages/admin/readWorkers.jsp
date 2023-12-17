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
        <th>ROLE</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="workers" items="${workers}">
        <tr>
            <td>${workers.firstname}</td>
            <td>${workers.surname}</td>
            <td>${workers.phoneNumber}</td>
            <td>${workers.workerType}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<button><a href="/pages/admin/admin.jsp">Back</a></button>
<form action="/logOut" method="get">
    <input style="font-size: 20px" type="submit" value="LogOut">
</form>
</body>
</html>
