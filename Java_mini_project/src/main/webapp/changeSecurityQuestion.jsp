<%@page import="Project.ConnectionProvider"%>
<%@page import="java.sql.*"%>
<%@include file="changeDetailsHeader.jsp"%>
<%@include file="footer.jsp"%>
<html>
<head>
<link rel="stylesheet" href="styles/changedetails.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<title>Change Details</title>
</head>
<body>
<%
String msg = request.getParameter("msg");
if("done".equals(msg)){
%>
<h3 class="alert">Your security Question successfully changed !</h3>
<%} %>
<% if("wrong".equals(msg)){ %>
<h3 class="alert">Your Password is wrong!</h3>
<%} %>
<form action="changeSecurityQuestionAction" method="post">
<h2>Select Your New Securtiy Question</h2>
		<select class="input-style" name="securityQuestion" required>
			<option value="What is your favorite color?">What is your favorite color?</option>
			<option value="What is your favorite food?">What is your favorite food?</option>
			<option value="What is your favorite movie?">What is your favorite movie?</option>
			</select>
			<hr>
			<h2>Enter Your New Answer</h2>
				<input class="input-style" type="text" name="newAnswer" placeholder="Enter Your New Answer" required>"
			<hr>
			<h2>Enter Password (For Security)</h2>
				<input class="input-style" type="password" name="password" placeholder="Enter Your Password(for security)" required>
			<hr>
			<button class="button" type="submit">Save<i class='far fa-arrow-alt-circle-right'></i></button>
	</form>

</body>
<br><br><br>
</html>