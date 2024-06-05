<%@page import="DTO.Employee" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
text-align: center;
}
</style>
</head>
<body>
 <%
 List<Employee> list = (List<Employee>)request.getAttribute("list");
 %>
 
 <table border="2px" cellpadding=0px cellspacing=10px>
 <tr>
 <th>ID</th>
 <th>NAME</th>
 <th>EMAIL</th>
 <th>PASSWORD</th>
 <th>CONTACT</th>
 <th>DELETE</th>
 <th>UPDATE</th>
 </tr>
 <% for(Employee e:list){
	 %>
	 
	 <tr>
	 <td><%=e.getId() %></td>
	  <td><%=e.getName() %></td>
	   <td><%=e.getEmail() %></td>
	    <td><%=e.getPassword() %></td>
	     <td><%=e.getContact() %></td>
	     <td><button><a href="delete?id=<%=e.getId() %>">Delete</a></button>
	     <td><button><a href="edit?id=<%=e.getId() %>">Update</a></button>
	  </tr>
	  <%
      }
	  %>
 
 </table>
</body>
</html>