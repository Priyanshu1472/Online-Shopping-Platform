<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles/signup.css">
<title>Signup</title>
</head>
<body>
<div id='container'>
  <div class='signup'>
    <form action="signupAction" method="post">
    <input type="text" name="name" placeholder="Enter Name" required>
    <input type="email" name="email" placeholder="Enter email" required>
    <input type="number" name="mobileNumber" placeholder="Enter Mobile Number" required>
    <select name="securityQuestion" required>
        <option value="What is your favourite color?">What is your favourite color?</option>
        <option value="What is your favourite food?">What is your favourite food?</option>
        <option value="What is your favourite movie?">What is your favourite movie?</option>
    </select>
    <input type="text" name="answer" placeholder="Enter Answer" required>
    <input type="password" name="password" placeholder="Enter Password" required>
    <input type="submit" value="signup">
      <h2><a href="login.jsp">Login</a></h2>
      </form>
  </div>
  <div class='whysign'>
<%
String msg=request.getParameter("msg");
if("valid".equals(msg)){
%>			
<h1>Successfully Registered !!!</h1>
<%}%>
<%
if("invalid".equals(msg)){
%>
<h1>Some thing Went Wrong! Try Again !</h1>
<%}%>

    <h2>Online Shopping Platform</h2>
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