 <%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<title>Update Courier</title>
<head>Update Courier</head>
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
    <form action="/update" method="post">
        <tr>
            <td><input type="text" name="firstname" value="${worker.firstname}"></td>
            <td><input type="text" name="surname" value="${worker.surname}"></td>
            <td><input type="text" name="phoneNumber" value="${worker.phoneNumber}"></td>
            <td><input type="submit" name="buttonCreate" value="update"></td>
            <td><input type="hidden" name="id" value="${worker.id}" ></td>
            <td><input type="hidden" name="login" value="${worker.login}"></td>
            <td><input type="hidden" name="password" value="${worker.password}"></td>
            <td><input type="hidden" name="role" value="${worker.userType}"></td>
        </tr>
    </form>
    </tbody>
</table>
<button><a href="/pages/admin/admin.jsp">Back</a></button>
</body>
</html>
