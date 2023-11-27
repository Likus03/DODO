<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>KitchenWorkers</title>
  <style type="text/css">
    th {
      color:lightblue;
      font-family:Arial
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
    <th>typeEmployee</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="kitchenWorkers" items="${kitchenWorkers}">
    <tr>
      <td>${kitchenWorkers.firstname}</td>
      <td>${kitchenWorkers.surname}</td>
      <td>${kitchenWorkers.phoneNumber}</td>
      <td>${kitchenWorkers.typeEmployee}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
