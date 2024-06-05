package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.Employee;

public class EmployeeDAO {

	static String classname = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/employee_db?user=root&password=root";

	public void saveEmployee(Employee e) {
		try {
			Class.forName(classname);
			Connection c = DriverManager.getConnection(url);
			PreparedStatement ps = c.prepareStatement("insert into employee values(?,?,?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getEmail());
			ps.setLong(4, e.getContact());
			ps.setString(5, e.getPassword());
			
			ps.executeUpdate();
			
			
			
			System.out.print("Data Saved");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public List FetchAllEmployee() {
		try {

			Class.forName(classname);
			Connection c = DriverManager.getConnection(url);
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from employee");

			ArrayList<Employee> al = new ArrayList();
			while (rs.next()) {

				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setContact(rs.getLong("contact"));
				e.setPassword(rs.getString("password"));
				al.add(e);
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteEmployeeById(int id) {
		try {
			Class.forName(classname);
			Connection c = DriverManager.getConnection(url);
			PreparedStatement ps = c.prepareStatement("delete from employee where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.print("Data Deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Employee fetchEmployeeById(int id) {
		try {
			Class.forName(classname);
			Connection c = DriverManager.getConnection(url);
			PreparedStatement ps = c.prepareStatement("select * from employee where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setContact(rs.getLong("contact"));
				e.setPassword(rs.getString("password"));
				return e;

			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateEmployeeById(Employee e) {
		try {
			Class.forName(classname);
			Connection c = DriverManager.getConnection(url);
			PreparedStatement ps = c
					.prepareStatement("update employee set name=?,email=?,contact=?,password=? where id=?");
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setLong(3, e.getContact());
			ps.setString(4, e.getPassword());
			ps.setInt(5, e.getId());
			ps.executeUpdate();
			System.out.println("Data Updated");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public Employee fetchEmployeeByEmail(String email) {
		try {
			Class.forName(classname);
			Connection c = DriverManager.getConnection(url);
			PreparedStatement ps = c.prepareStatement("select * from employee where email=?");
			ps.setString(1, email);
		   ResultSet rs= ps.executeQuery();
		   if(rs.next()) {
			   Employee e=new Employee();
			   e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setContact(rs.getLong("contact"));
				e.setPassword(rs.getString("password"));
				return e;
		   }
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
