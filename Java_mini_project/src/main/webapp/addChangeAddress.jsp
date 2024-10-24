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
String msg=request.getParameter("msg");
if("valid".equals(msg)){
%>
<h3 class="alert">Address Successfully Updated !</h3>
<%} %>
<%
if("invalid".equals(msg)){
%>
<h3 class="alert">Some thing Went Wrong! Try Again!</h3>
<%} %>
<%
try{
	    Connection con=ConnectionProvider.getCon(); 
    Statement st = con.createStatement(); 
    ResultSet rs = st.executeQuery("select * from users where email='"+email+"'");
    while(rs.next()){
%>
<form action="addChangeAddressAction" method="post">
<h2>Enter Address</h2>
 <input class="input-style" type="text" value="<%=rs.getString(7) %>" name="address" placeholder="Enter Address" required>
 <hr>
 <h2>Enter city</h2>
 <input class="input-style" type="text" value="<%=rs.getString(8) %>" name="city" placeholder="Enter City" required>
<hr>
<h2>Enter State</h2>
<input class="input-style" type="text" value="<%=rs.getString(9) %>" name="state" placeholder="Enter State" required>
<hr>
<h2>Enter country</h2>
<input class="input-style" type="text" value="<%=rs.getString(10) %>" name="country" placeholder="Enter Country" required>
<hr>
 <button class="button" type="submit">Save <i class='far fa-arrow-alt-circle-right'></i></button>
 </form>
	<%
	}
	   } catch (Exception e) {
	System.out.println(e);
	}
	%>
</body>
<br><br><br>
</html>