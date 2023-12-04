<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<title>Update Manager</title>
<head>Update Manager</head>
<body>
<table>
    <thead>
    <tr>
        <th>firstname</th>
        <th>family</th>
        <th>phoneNumber</th>
    </tr>
    </thead>
    <tbody>
    <form action="/managers/read" method="post">
        <tr>

            <td><input type="text" name="firstname" value="${managers.firstname}"></td>
            <td><input type="text" name="surname" value="${managers.surname}"></td>
            <td><input type="text" name="phoneNumber" value="${managers.phoneNumber}"></td>
            <td><input type="submit" name="buttonCreate" value="update"></td>
            <td><input type="hidden" name="id" value="${managers.id}" ></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
