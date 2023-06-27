<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
 <h2>New User Registration</h2>
<div class="container">
 <small style="background-color:DodgerBlue;">${msg}</small> 
</div>
 <div class="container"> 
 <form action ="saveReg" method="post">
  <table>
  <tr>
    <td>First Name</td>
    <td><input type ="text" name="firstName"></td>
  </tr>
  <tr>
    <td>Last Name</td>
    <td><input type ="text" name="lastName"></td>
  </tr>
  <tr>
    <td>Email</td>
    <td><input type ="text" name="email"></td>
  </tr>
  <tr>
    <td>Password</td>
    <td><input type ="password" name="password"></td>
  </tr>
    <tr>
    <td><input type ="submit" value="save"></td>
  </tr>
   </table>
 </form>
 </div>  
</body>
</html>