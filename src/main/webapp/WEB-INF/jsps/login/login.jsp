<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>Login Here</h2>
  ${msg}
  <table>
  <tr>
   <form action="verifyLogin" method="post">
   User Name<input type="text" name="email">
   Password<input type="password" name="password">
    <input type="submit" value="login"/>
   </form>
   </tr>
  </table>

</body>
</html>