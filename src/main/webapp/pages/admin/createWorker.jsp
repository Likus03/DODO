<html>
<title>Create worker</title>
<head>Create new Worker</head>
<body>
<table>
  <thead>
  <tr>
    <th>firstname</th>
    <th>family</th>
    <th>phoneNumber</th>
    <th>deliveryType</th>
    <th>login</th>
    <th>password</th>
    <th>role</th>
  </tr>
  </thead>
  <tbody>
  <form action="/create" method="post">
    <tr>
      <td><input type="text" name="firstname" placeholder="put your firstname"></td>
      <td><input type="text" name="surname" placeholder="put your surname"></td>
      <td><input type="text" name="phoneNumber" placeholder="put your phone number"></td>
      <td><input type="text" name="deliveryType" placeholder="put your delivery type"></td>
      <td><input type="text" name="login" placeholder="put your login"></td>
      <td><input type="text" name="password" placeholder="put your password"></td>
      <td><select name="workerType" size="1">
        <option selected value="Manager">Manager</option>
        <option value="Courier">Courier</option>
        <option value="KitchenWorker">Kitchen Worker</option>
      </select></td>
      <td><input type="submit" name="buttonCreate" value="sing up"></td>
    </tr>
  </form>
  </tbody>
</table>
</body>
</html>
