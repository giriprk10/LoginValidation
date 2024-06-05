<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
div {
    text-align: center;
    margin-top: 50px;
}
h1 {
    margin-top: 25px;
}
#opt {
    color: red;
}
a {
    color: black;
    text-decoration: none;
}
#del {
    text-decoration: none;
}
</style>
</head>
<body>
<div>
<form action="login" method="post">
    <h1>LOGIN PAGE</h1>
    <label>EMAIL ID:</label>
    <input type="email" name="email" placeholder="Enter your email id" required><br><br>
    <label>PASSWORD:</label>
    <input type="password" name="pwd" placeholder="Enter your password" required><br><br>
    <input type="submit" value="Login">
    <button onclick="window.location.href='./SignIn.jsp'">Sign Up</button>
<br><br>
<% String message = (String) request.getAttribute("msg");
if (message != null) { %>
    <h1 id="opt"><%= message %></h1>
<% } %>
</form>

</div>
</body>
</html>
