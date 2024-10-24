
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles/login.css">
<title>Login</title>
</head>
<body>
<div id='container'>
  <div class='signup'>
     <form action="loginAction" method="post">
     <input type="email" name="email" placeholder="Enter Email" required>
   	 <input type="password" name="password" placeholder="Enter Password" required>
   	 <input type="submit" value="login">
     </form>
    <h2><a href="signup.jsp">SignUp</a></h2>
    <h2><a href="forgotPassword.jsp">Forgot Password?</a></h2>
  </div>
  <div class='whysignLogin'>
  <% String msg=request.getParameter("msg"); %>
  <% if("UserNotFound".equals(msg)){ %>
  <h1>Incorrect Username or Password</h1>
  <%} %>
  <%if("invaild".equals(msg)) {%>
  <h1>Some thing Went Wrong! Try Again !</h1>
  <%} %>

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