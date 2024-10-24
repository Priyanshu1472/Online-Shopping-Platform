<%@page import="Project.ConnectionProvider"%>
<%@page import="java.sql.*"%>
<%@include file="changeDetailsHeader.jsp"%>
<%@include file="footer.jsp"%>
<html>
<head>
<link rel="stylesheet" href="styles/changedetails.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<title>Chnage details</title>
</head>
<body>
<%
String msg = request.getParameter("msg");
if("done".equals(msg)){
%>
<h3 class="alert">Your Mobile Number successfully changed!</h3>
<%} %>
<%
if("wrong".equals(msg)){
%>
<h3 class="alert">Your Password is wrong!</h3>
<%} %>
<form action="changeMobileNumberAction" method="post">
 <h2>Enter Your New Mobile Number</h2>
 <input class="input-style" type="number" name="mobileNumber" placeholder="Enter New Mobile Number" required>
 <hr>
<h2>Enter Password (For Security)</h2>
 <input class="input-style" type="password" name="password" placeholder="Enter Password(for Security)" required>
<hr>
 <button class="button" type="submit">Save<i class='far fa-arrow-alt-circle-right'></i></button>
</form>
</body>
<br><br><br>
</html>