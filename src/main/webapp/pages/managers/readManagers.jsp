<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Managers</title>
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
    </tr>
    </thead>
    <tbody>
    <form action="/managers/update" method="post">
    <c:forEach var="managers" items="${managers}">
        <tr>
            <td>${managers.firstname}</td>
            <td>${managers.surname}</td>
            <td>${managers.phoneNumber}</td>
            <td><input type="radio" id="${managers.id}" name="radioGroup" value="${managers.id}"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<td><input type="submit" name="editManager" value="delete"></td>
<td><input type="submit" name="editManager" value="update"></td>

</body>
</html>
