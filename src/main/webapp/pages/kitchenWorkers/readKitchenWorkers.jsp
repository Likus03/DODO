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
    <th>ROLE</th>
  </tr>
  </thead>
  <tbody>
  <form action="/kitchenWorkers/update" method="post">
  <c:forEach var="kitchenWorkers" items="${kitchenWorkers}">
    <tr>
      <td>${kitchenWorkers.firstname}</td>
      <td>${kitchenWorkers.surname}</td>
      <td>${kitchenWorkers.phoneNumber}</td>
      <td>${kitchenWorkers.typeEmployee}</td>
      <td>${kitchenWorkers.userType}</td>
      <td><input type="radio" id="${kitchenWorkers.id}" name="radioGroup" value="${kitchenWorkers.id}"></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<td><input type="submit" name="editKitchenWorker" value="delete"></td>
<td><input type="submit" name="editKitchenWorker" value="update"></td>
</body>
</html>
