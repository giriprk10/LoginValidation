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
@WebServlet("/save")
public class SaveServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name= req.getParameter("name");
		String email=req.getParameter("email");
		long contact=Long.parseLong(req.getParameter("phone"));
		String password=req.getParameter("pwd");
		
		Employee e=new Employee();
		e.setId(id);
		e.setName(name);
		e.setEmail(email);
		e.setContact(contact);
		e.setPassword(password);
		
		EmployeeDAO emp= new EmployeeDAO();
		emp.saveEmployee(e);
		
		req.setAttribute("msg","Data Saved Successfully");
		RequestDispatcher rd=req.getRequestDispatcher("Student.jsp");
		rd.forward(req, resp);
		 
	}
}

	