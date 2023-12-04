<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<title>Update Kitchen Worker</title>
<head>Update Kitchen Worker</head>
<body>
<table>
  <thead>
  <tr>
    <th>firstname</th>
    <th>family</th>
    <th>phone Number</th>
    <th>type Employee</th>
  </tr>
  </thead>
  <tbody>
  <form action="/kitchenWorkers/read" method="post">
    <tr>

      <td><input type="text" name="firstname" value="${kitchenWorkers.firstname}"></td>
      <td><input type="text" name="surname" value="${kitchenWorkers.surname}"></td>
      <td><input type="text" name="phoneNumber" value="${kitchenWorkers.phoneNumber}"></td>
      <td><input type="text" name="typeEmployee" value="${kitchenWorkers.typeEmployee}"></td>
      <td><input type="submit" name="buttonCreate" value="update"></td>
      <td><input type="hidden" name="id" value="${kitchenWorkers.id}" ></td>
    </tr>
  </form>
  </tbody>
</table>
</body>
</html>
