<%@page import="Project.ConnectionProvider"%>
<%@page import="java.sql.*"%>
<%@include file="adminHeader.jsp"%>
<%@include file="../footer.jsp"%>
<html>
<head>
<link rel="stylesheet" href="../styles/addnewproduct.css">
<title>Add New Product</title>
</head>
<body>

<%String msg=request.getParameter("msg");
if("done".equals(msg)){%>
<h3 class="alert">Product Added Successfully!</h3>
<%}%>

<%if("wrong".equals(msg)){%>
<h3 class="alert">Some thing went wrong! Try Again!</h3>
<%}%>

<%
int id=1;
try{
	Connection con = ConnectionProvider.getCon();
	Statement st = con.createStatement();
	ResultSet rs=st.executeQuery("select max(id) from product");
	while (rs.next()) {
        id=rs.getInt(1);
        id++;
    }
}
catch(Exception e) {
	System.out.println(e);
}
%>
	<form action="/Java_mini_project/addNewProductAction" method="post">

<h3 style="color: black;">Product ID:<%out.println(id); %> </h3>
<input type="hidden" name="id" value="<%out.println(id); %>">

<div class="left-div">
 <h3>Enter Name</h3>
 <input class="input-style" type="text" name="name" placeholder="Enter Producat Name" required>
<hr>
</div>

<div class="right-div">
<h3>Enter Category</h3>
 <input class="input-style" type="text" name="category" placeholder="Enter Producat Category" required>
<hr>
</div>

<div class="left-div">
<h3>Enter Price</h3>
 <input class="input-style" type="number" name="price" placeholder="Enter Producat Price" required>
<hr>
</div>

<div class="right-div">
<h3>Active</h3>
   <select class="input-style" name="active">
   <option value="yes">Yes</option>
   <option value="no">No</option>
   </select>
<hr>
</div>
 <button class="button">Add Product</button>
</form>
</body>
<br><br><br>
</body>
</html>