<html>
<title>Create courier</title>
<head>Create new Courier</head>
<body>
<table>
  <thead>
  <tr>
    <th>firstname</th>
    <th>family</th>
    <th>phoneNumber</th>
    <th>deliveryType</th>
  </tr>
  </thead>
  <tbody>
  <form action="/couriers/create" method="post">
    <tr>
      <td><input type="text" name="firstname" placeholder="put your firstname"></td>
      <td><input type="text" name="surname" placeholder="put your surname"></td>
      <td><input type="text" name="phoneNumber" placeholder="put your phone number"></td>
      <td><input type="text" name="deliveryType" placeholder="put your delivery type"></td>
      <td><input type="submit" name="buttonCreate" value="create"></td>
    </tr>
  </form>
  </tbody>
</table>
</body>
</html>
