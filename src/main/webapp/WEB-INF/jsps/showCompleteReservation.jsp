<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Complete Reservation</title>
</head>
<body>
 <h2>Flight Details</h2>
  OperatingAirlines: ${flight.operatingAirlines}
  <br/>
  Departure City: ${flight.departureCity}
  <br/>
  Arrival City: ${flight.arrivalCity}
  <br/>
  Departure Date & Time: ${flight.estimatedDepartureTime}
  <br/>
  
  <h2>Enter Passenger Details</h2>
  <form action="confirmReservation" method="post">
  <pre>
  First Name:<input type="text" name="firstName"/>
  Last Name:<input type="text" name="lastName"/>
  Middle Name:<input type="text" name="middleName"/>
  Email:<input type="text" name="email"/>
  Phone:<input type="text" name="phone"/>
  <input type="hidden" name="flightId" value="${flight.id}"/>
  
  <h2>Enter The Payment Details</h2>
  Name:<input type="text" name="name"/>
  Card Number:<input type="text" name="cardNumber"/>
  Cvv Code:<input type="text" name="cvvCode"/>
  Expiry Date :<input type="text" name="expiryDate"/>
  Amount:<input type="text" name="amount"/>
  <input type="submit" value="save"/>
  
  </pre>
  </form>
  
</body>
</html>