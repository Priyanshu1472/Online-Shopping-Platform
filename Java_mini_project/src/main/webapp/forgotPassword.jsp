<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles/forgotpassword.css">
<title>ForgotPassword</title>
</head>
<body>
<div id='container'>
  <div class='signup'>
     <form action="forgotPasswordAction" method="post">
     <input type="email" name="email" placeholder="Enter Email" required>
     <input type="number" name="mobileNumber" placeholder="Enter Mobline Number" required>
     <select name="securityQuestion" required>
     <option value="What is your favourite color?">What is your favourite color?</option>
     <option value="What is your favourite food?">What is your favourite food?</option>
     <option value="What is your favourite movie?">What is your favourite movie?</option>
     </select>
     <input type="text" name="answer" placeholder="Enter Answer" required>
     <input type="password" name="newPassword" placeholder="Enter New Password" required>
     <input type="submit" value="save">
      <h2><a href="login.jsp">Login</a></h2>
      </form>
  </div>
  <div class='whyforgotPassword'>
<%
String msg=request.getParameter("msg");
if("done".equals(msg))
{%>
<h1>Password Changed Successfully!</h1>
<%}%>

<%if("invalid".equals(msg))
{%>
<h1>Some thing Went Wrong! Try Again !</h1>
<%}%>
    <h2>Online Shopping</h2>
    <br>
    <br>
    <h3>By</h3>
    <br>
    <h3>Name: Priyanshu Arora <br>PRN:22030121159</h3>
    <br>
    <h3>Name: Kushal Kumawat <br>PRN:22030121121</h3>
  </div>
</div> 
</body>
</html>