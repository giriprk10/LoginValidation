package CONTROLLER;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmployeeDAO;
import DTO.Employee;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String email= req.getParameter("email");
	String password= req.getParameter("pwd");
	
	EmployeeDAO emp=new EmployeeDAO();
	Employee e=emp.fetchEmployeeByEmail(email);
	
	if(e!=null) {
		
		if(password.equals(e.getPassword())) {
			RequestDispatcher rd=req.getRequestDispatcher("View");
			rd.forward(req, res);
		}else {
			req.setAttribute("msg","Entered Password is Invalid");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req, res);
		}
		
	}
	
	else {
		req.setAttribute("msg","Entered Email is Invalid");
		RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
		rd.forward(req, res);
	}
	 
}
}
