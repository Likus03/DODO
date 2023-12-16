<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>DELETE</title>

  <style type="text/css">
    th {
      color: lightblue;
      font-family: Arial
    }
  </style>

</head>
<body>
<h3 style="text-align: center">Choose to update</h3>
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
  <form action="/delete" method="post">
    <c:forEach var="workers" items="${workers}">
    <tr>
      <td>${workers.firstname}</td>
      <td>${workers.surname}</td>
      <td>${workers.phoneNumber}</td>
      <td>${workers.userType}</td>
      <td><input type="radio" name="radioGroup" value="${workers.id}"></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<input type="submit" name="deleteWorker" value="delete">
<button><a href="/pages/admin/admin.jsp">Back</a></button>
<form action="/logOut" method="get">
  <input style="font-size: 20px" type="submit" value="LogOut">
</form>
</body>
</html>
