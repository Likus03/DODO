<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Managers</title>
</head>
<body>
<table>
  <thead>
  <tr>
    <th>NAME</th>
    <th>FAMILY</th>
    <th>phoneNumber</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="managers" items="${managers}">
    <tr>
      <td>${managers.firstname}</td>
      <td>${managers.surname}</td>
      <td>${managers.phoneNumber}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
