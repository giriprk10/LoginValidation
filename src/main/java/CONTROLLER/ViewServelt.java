package CONTROLLER;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmployeeDAO;
import DTO.Employee;
@WebServlet("/View")
public class ViewServelt extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmployeeDAO emp=new EmployeeDAO();
		
		List<Employee> list=emp.FetchAllEmployee();
		req.setAttribute("list", list);
		
		RequestDispatcher rd=req.getRequestDispatcher("View.jsp");
		rd.forward(req, resp);
	}

}
