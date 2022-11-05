package com.amaan.first.ECRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amaan.first.User;



@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class EmployeeListController {
	
	@PostMapping("/signup")
	public Map home4(HttpServletRequest req) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "admin1");
		String employee_id = req.getParameter("employee_id");
		String name = req.getParameter("name");
		String designation = req.getParameter("designation");
		String dob = req.getParameter("dob");
		String salary = req.getParameter("salary");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		//String joining_date = req.getParameter("joining_date");
		String contact_no = req.getParameter("contact_no");
		String address = req.getParameter("address");
		String gender = req.getParameter("gender");
		
		
		
		Statement stmt = con.createStatement();
		String query = "Select * from employee_table where email ='" + email +"'";
		ResultSet rs = stmt.executeQuery(query);
		HashMap map = new HashMap();
		if(rs.next())
		{
			map.put("message","You are already signed up please try to login");
			return map;
		}
		else
		{
			String queryInsert = "insert into employee_table(employee_id,name,designation,dob,salary,email,password,joining_date,contact_no,address,gender,attendance,leave_count,status) values(?,?,?,?,?,?,?,CURDATE(),?,?,?,0,0,'non-active')";
			PreparedStatement pstmt1 = con.prepareStatement(queryInsert);
			pstmt1.setString(1, employee_id);
			pstmt1.setString(2, name);
			pstmt1.setString(3, designation);
			pstmt1.setString(4, dob);
			pstmt1.setString(5, salary);
			pstmt1.setString(6, email);
			pstmt1.setString(7, password);
			pstmt1.setString(8, contact_no);
			pstmt1.setString(9, address);
			pstmt1.setString(10,gender);
			
			int i = pstmt1.executeUpdate();
			
			if(i>=1)
			{
				map.put("message", "You are signed up Successfully");
				return map;
			}
			else
				map.put("message", "Something went wrong please try again later");
			return map;
			
		}
		
//		PreparedStatement pstmt1 = con.prepareStatement(query);
//		ResultSet rs1 = pstmt1.executeQuery();
//		while(rs1.next()) {
//			map.put(rs1.getString(0))
//		}
//
//		}
	}
	@PostMapping("/loginadmin")
	 public Map adminlogin(HttpServletRequest req) throws SQLException, ClassNotFoundException {
		 
		    String email = req.getParameter("email");
			String password = req.getParameter("password");
			String adminemail="admin@gmail.com";
			String adminpass = "admin@123";
			HashMap map = new HashMap();
			if(email.equalsIgnoreCase(adminemail) && password.equals(adminpass))
			{
				map.put("message","You have logged in Successfully");

			}
			else
				map.put("message", "Invalid Credentials");
				
			
			//Statement stmt = con.createStatement();
			//String query = "Select * from employee_table where email ='" + email +"'";
			
			
			
			
			return map;
		  
	  }

	@PostMapping("/login")
	  public Map home7(HttpServletRequest req) throws SQLException, ClassNotFoundException {
		  Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "admin1");
			String email = req.getParameter("email");
			
			String password = req.getParameter("password");
			
			Statement stmt = con.createStatement();
			String query = "Select * from employee_table where email ='" + email +"'";
			ResultSet rs = stmt.executeQuery(query);
			HashMap map = new HashMap();
			if(rs.next())// if email exists
			{
				String queryCheck = "Select * from employee_table where password = '" + password + "'";
				Statement stmt1 = con.createStatement();
				ResultSet rs1 = stmt.executeQuery(queryCheck);
				if(rs1.next())//if password matches
				{
					map.put("message","You have logged in Successfully");
				}
				else
					map.put("message", "Incorrect Password");
					
				
			}
			else//email doesnt exist
			{
				map.put("message", "You need to create an account first, Sign Up");
			}
			return map;
		  
	  }

	@GetMapping("/admin/employeelist")
	public ArrayList employeelist1() throws ClassNotFoundException, SQLException 
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","admin1");
	Statement stmt=con.createStatement();
	String fatchquery="select * from employee_table where status='non-active'";
	ResultSet rs=stmt.executeQuery(fatchquery);
	ArrayList l=new ArrayList();
	while(rs.next()) {
		HashMap hm=new HashMap();
		hm.put("employee_id",rs.getInt("employee_id"));
		hm.put("name", rs.getString("name"));
		hm.put("email", rs.getString("Email"));
		l.add(hm);
}
	return l;

}
	@PostMapping("/admin/newsignups")
	public ArrayList employeelist2() throws ClassNotFoundException, SQLException 
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e","root","admin1");
	Statement stmt=con.createStatement();
	String fatchquery="select * from employee_table where status='active'";
	ResultSet rs=stmt.executeQuery(fatchquery);
	ArrayList l=new ArrayList();
	while(rs.next()) {
		HashMap hm=new HashMap();
		hm.put("employee_id",rs.getInt("employee_id"));
		hm.put("name", rs.getString("name"));
		hm.put("email", rs.getString("Email"));
		l.add(hm);
}
	return l;

}
	@GetMapping("/admin/get_notice")
	public List home1(HttpServletRequest req) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","admin1");
		Statement stmt=con.createStatement();
		String query="select * from notice";
		ResultSet rs=stmt.executeQuery(query);
		ArrayList list=new ArrayList();
		while(rs.next())
		{
			HashMap map=new LinkedHashMap();
			map.put("Date",rs.getDate("rel_time"));
			map.put("Notice",rs.getString("notice"));
			list.add(map);
		}
		return list;
		
	}
	
	

}
