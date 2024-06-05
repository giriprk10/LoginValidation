<%@page import="DTO.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div{
text-align: center;
margin-top: 50px;
}
h1{
margin-top:25px;
}
#opt{
color: red;
}
a{
color: black;
text-decoration: none;
}
</style>
</head>
<body>
  <% Employee e=(Employee) request.getAttribute("emp"); %>
  <div>
  <form action="update" >
<h1>UPDATE FORM </h1>
<label>ID:</label>
<input type="text" id="inp1" name="id" placeholder="Enter your Name"  value="<%= e.getId() %>" readonly="readonly" required="required"><br><br>
<label>NAME:</label>
<input type="text"  name="name" placeholder="Enter your Name" value="<%=e.getName() %>" required="required" ><br><br>
<label>EMAIL ID:</label>
<input type="email"  name="email" placeholder="Enter your email id" value="<%=e.getEmail() %>" required="required"><br><br>
<label>CONTACT:</label>
<input type="tel"  name="phone" placeholder="Enter your Number" value="<%=e.getContact() %>" required="required"><br><br>
<label>PASSWORD:</label>
<input type="password"   name="pwd" placeholder="Enter your password" value="<%=e.getPassword() %>" required="required"><br><br>
<input type="submit">
</div>
</body>
</html>