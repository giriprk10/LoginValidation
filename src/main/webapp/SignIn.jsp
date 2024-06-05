<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1{
text-align: center;
}
div{
text-align:center;
}
#opt{
color: red;
}
</style>
</head>
<body>
<div>
<form action="save" method="post">
<h1>EMPLOYEE SIGN IN </h1>
<label>ID:</label>
<input type="text" id="inp1" name="id" placeholder="Enter your Name" required><br><br>
<label>NAME:</label>
<input type="text"  name="name" placeholder="Enter your Name" required><br><br>
<label>EMAIL ID:</label>
<input type="email"  name="email" placeholder="Enter your email id" required><br><br>
<label>CONTACT:</label>
<input type="tel"  name="phone" placeholder="Enter your Number" required><br><br>
<label>PASSWORD:</label>
<input type="password"   name="pwd" placeholder="Enter your password" required><br><br>
<input type="submit">

<br><br>
<% String data=(String)request.getAttribute("msg");
  if(data!=null){
%>
<h1 id="opt"><%=data %></h1>
<% } %>
</form>
</div>
</body>
</html>