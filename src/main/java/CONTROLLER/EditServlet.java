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
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      int id=Integer.parseInt(req.getParameter("id"));
      EmployeeDAO emp=new EmployeeDAO();
      Employee e=emp.fetchEmployeeById(id);
      
      req.setAttribute("emp", e);
      RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
      rd.forward(req, resp);
}
}
