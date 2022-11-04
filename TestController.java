package com.codeplanet.Application3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {
	@Autowired
	TestService testService;
	
// //update employe id=====>
	
	
	@PutMapping("/admin/update")
	public Map updateEmployee(HttpServletRequest req) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","admin1");
		String employee_id = req.getParameter("employee_id");
		String name = req.getParameter("name");
		String designation = req.getParameter("designation");
		String dob = req.getParameter("dob");
		String salary = req.getParameter("salary");
		String Email = req.getParameter("Email");
		String joining_date = req.getParameter("joining_date");
		String contact_no = req.getParameter("contact_no");
		String address = req.getParameter("address");
		String gender = req.getParameter("gender");
		String attendance = req.getParameter("attendance");
		String leave_count = req.getParameter("leave_count");
		Statement stmt=con.createStatement();
		String query ="Select * from employee_table where employee_id='"+employee_id+"'";
		ResultSet emp =stmt.executeQuery(query);
		HashMap<String,String> map1=new HashMap<String,String>();
		while(emp.next()) {
			if((emp.getString("name").equals(name))==false) 
			{
			  String query1= "update employee_table set name=? where employee_id='"+employee_id+"'";
			  PreparedStatement pstmt=con.prepareStatement(query1);
			  pstmt.setString(1,name);
			  int i =pstmt.executeUpdate();
			  HashMap map=new HashMap();
			  if(i>=1) {
				  map.put("message", "name updated");
				  return map;
			  }
			}
		else if((emp.getString("designation").equals(designation))==false) 
		{
			  String query1= "update employee_table set designation=? where employee_id='"+employee_id+"'";
			  PreparedStatement pstmt=con.prepareStatement(query1);
			  pstmt.setString(1,designation);
			  int i =pstmt.executeUpdate();
			  HashMap map=new HashMap();
			  if(i>=1) 
			  {
				  map.put("message", "designation updated");
				  return map;
			  }
			}
		else if((emp.getString("dob").equals(dob))==false) 
		{
			  String query1= "update employee_table set dob=? where employee_id='"+employee_id+"'";
			  PreparedStatement pstmt=con.prepareStatement(query1);
			  pstmt.setString(1,dob);
			  int i =pstmt.executeUpdate();
			  HashMap map=new HashMap();
			  if(i>=1) 
			  {
				  map.put("message", "dob updated");
				  return map;
			  }
			}
		else if((emp.getString("salary").equals(salary))==false) 
		{
			  String query1= "update employee_table set salary=? where employee_id='"+employee_id+"'";
			  PreparedStatement pstmt=con.prepareStatement(query1);
			  pstmt.setString(1,salary);
			  int i =pstmt.executeUpdate();
			  HashMap map=new HashMap();
			  if(i>=1) 
			  {
				  map.put("message", "salary updated");
				  return map;
			  }
			}
		else if((emp.getString("Email").equals(Email))==false) 
		{
			  String query1= "update employee_table set Email=? where employee_id='"+employee_id+"'";
			  PreparedStatement pstmt=con.prepareStatement(query1);
			  pstmt.setString(1,Email);
			  int i =pstmt.executeUpdate();
			  HashMap map=new HashMap();
			  if(i>=1) 
			  {
				  map.put("message", "Email updated");
				  return map;
			  }
			}
		else if((emp.getString("joining_date").equals(joining_date))==false) 
		{
			  String query1= "update employee_table set joining_date=? where employee_id='"+employee_id+"'";
			  PreparedStatement pstmt=con.prepareStatement(query1);
			  pstmt.setString(1,joining_date);
			  int i =pstmt.executeUpdate();
			  HashMap map=new HashMap();
			  if(i>=1) 
			  {
				  map.put("message", "joining_date updated");
				  return map;
			  }
			}
		else if((emp.getString("contact_no").equals(contact_no))==false) 
		{
			  String query1= "update employee_table set contact_no=? where employee_id='"+employee_id+"'";
			  PreparedStatement pstmt=con.prepareStatement(query1);
			  pstmt.setString(1,contact_no);
			  int i =pstmt.executeUpdate();
			  HashMap map=new HashMap();
			  if(i>=1) 
			  {
				  map.put("message", "contact_no updated");
				  return map;
			  }
			}
		else if((emp.getString("address").equals(address))==false) 
		{
			  String query1= "update employee_table set address=? where employee_id='"+employee_id+"'";
			  PreparedStatement pstmt=con.prepareStatement(query1);
			  pstmt.setString(1,address);
			  int i =pstmt.executeUpdate();
			  HashMap map=new HashMap();
			  if(i>=1) 
			  {
				  map.put("massage", "address updated");
				  return map;
			  }
			}
		else if((emp.getString("gender").equals(gender))==false) 
		{
			  String query1= "update employee_table set gender=? where employee_id='"+employee_id+"'";
			  PreparedStatement pstmt=con.prepareStatement(query1);
			  pstmt.setString(1,gender);
			  int i =pstmt.executeUpdate();
			  HashMap map=new HashMap();
			  if(i>=1) 
			  {
				  map.put("massage", "gender updated");
				  return map;
			  }
			}
		else if((emp.getString("attendance").equals(attendance))==false) 
		{
			  String query1= "update employee_table set attendance=? where employee_id='"+employee_id+"'";
			  PreparedStatement pstmt=con.prepareStatement(query1);
			  pstmt.setString(1,attendance);
			  int i =pstmt.executeUpdate();
			  HashMap map=new HashMap();
			  if(i>=1) 
			  {
				  map.put("massage", "attendance updated");
				  return map;
			  }
			}
		else if((emp.getString("leave_count").equals(leave_count))==false) 
		{
			  String query1= "update employee_table set leave_count=? where employee_id='"+employee_id+"'";
			  PreparedStatement pstmt=con.prepareStatement(query1);
			  pstmt.setString(1,leave_count);
			  int i =pstmt.executeUpdate();
			  HashMap map=new HashMap();
			  if(i>=1) 
			  {
				  map.put("massage", "leave_count updated");
				  return map;
			  }
			}
		else
	    {
			map1.put("massage", "your data is already correct!!");
			return map1;
		}
		return map1;
		}
		return map1;
	}
	
	
	
//	// delete employee data====>
	
	@DeleteMapping("/admin/delete")
		public Map deleteEmployee(HttpServletRequest req) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","admin1");
		String employee_id = req.getParameter("employee_id");
		String query= "delete from employee_table where employee_id=?";
		PreparedStatement stmt=con.prepareStatement(query);
		stmt.setString(1,employee_id);
		int i=stmt.executeUpdate();
		HashMap<String,String> map2=new HashMap<String,String>();
		if(i>=1)
		{
			map2.put("message","Your data deleted");
			return map2;
		}
		return map2;
	}
	

////	request to edit data=======>
	
	@PutMapping("employee/requestToUpdate")
	public Map employee(HttpServletRequest req) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","admin1");
		String employee_id = req.getParameter("employee_id");
		String requestToUpdate = req.getParameter("requestToUpdate");
		Statement stmt=con.createStatement();
		String query ="Select * from employee_table where employee_id='"+employee_id+"'";
		ResultSet emp =stmt.executeQuery(query);
		if(emp.next()) 
			{
				String query1="update employee_table set requestToUpdate=? where employee_id='"+employee_id+"'";
				  PreparedStatement pstmt=con.prepareStatement(query1);
				  pstmt.setString(1,requestToUpdate);
				  int i =pstmt.executeUpdate();
				  HashMap map=new HashMap();
				  if(i>=1)
				  {
					  map.put("message","Your request send successfully");
					  return map; 
				  }
			}
			return null;
	}
	
	
	
	
//	employee profile =======>
	
	
	@GetMapping("/profile")
	public List profileEmployee(HttpServletRequest req) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","admin1");
		String employee_id = req.getParameter("employee_id");
		String password = req.getParameter("password");
		Statement stmt=con.createStatement();
		String query = "Select * from employee_table where employee_id='"+employee_id+"' OR password='"+password+"'";;
		ResultSet emp =stmt.executeQuery(query);
		LinkedHashMap map1=new LinkedHashMap();
		ArrayList list=new ArrayList();
		while(emp.next()) {
			if((emp.getString("employee_id").equals(employee_id)) && (emp.getString("password").equals(password)) ){
			{
				map1.put("employee_id", emp.getString("employee_id"));
				map1.put("name", emp.getString("name"));
				map1.put("designation", emp.getString("designation"));
				map1.put("dob", emp.getString("dob"));
				map1.put("salary", emp.getString("salary"));
				map1.put("Email", emp.getString("Email"));
				map1.put("joining_date", emp.getString("joining_date"));
				map1.put("contact_no", emp.getString("contact_no"));
				map1.put("address", emp.getString("address"));
				map1.put("gender", emp.getString("gender"));
				map1.put("attendance", emp.getString("attendance"));
				map1.put("leave_count", emp.getString("leave_count"));
				list.add(map1);
			  }
			return list;
			}
		 else if((emp.getString("employee_id").equals(employee_id))==false)
			{
				map1.put("massage", "your employee_id is incoreact!!Try again!!");
				list.add(map1);
				return list;
			}
		else 
			{
				map1.put("massage", "your password is incoreact!!Try again!!");
				list.add(map1);
				return list;
			}
		}
		return list;
	}
}
	


