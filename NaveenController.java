package com.naveen.App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaveenController {



@PostMapping("/user/complaintAdd")//user
public HashMap Complaint(HttpServletRequest req) throws ClassNotFoundException, SQLException
{
	String employee_id=req.getParameter("employee_id");
	String complain_text=req.getParameter("complain_text");
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root",
			"admin1");
	Statement stmt=con.createStatement();
	HashMap<String,String> map=new HashMap<String,String>();
		 String queryInsert="insert into complain(employee_id,complain_text) values(?,?)";
			PreparedStatement pstmt2=con.prepareStatement(queryInsert);
			pstmt2.setString(1,employee_id);
			 pstmt2.setString(2,complain_text);
			 int i=pstmt2.executeUpdate();
			 if(i>=1) {
			map.put("message", "your commplaint register successfully");
			return map;
			 }
			 else
			 {
				 map.put("message","something went wrong");
				 return map;
			 }
}



@PostMapping("/admin/complaintShow")//admin
public HashMap ShowComplaint(HttpServletRequest req) throws ClassNotFoundException, SQLException
{

	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root",
			"admin1");
	Statement stmt=con.createStatement();
	String query="select * from employeemanagement.complain";
	ResultSet rs=stmt.executeQuery(query);
	HashMap<String,Integer> map=new HashMap<String,Integer>();
	 while(rs.next())
	{
		 map.put(rs.getString("complain_text"),rs.getInt("employee_id"));
	}
	    return map;
		
}



@PostMapping("/admin/complaintDelete")//admin
public String DeleteComplaint(HttpServletRequest req) throws ClassNotFoundException, SQLException
{
	String complain_id=req.getParameter("complain_id");
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root",
			"admin1");
	Statement stmt=con.createStatement();
	String query="delete from employeemanagement.complain where complain_id='"+complain_id+"'";
	int result=stmt.executeUpdate(query);
	if(result<=1)
		return "deleted successfully";
	else
		return "something went wrong"; 
}



@PostMapping("/admin/searchEmployee")//admin
public HashMap SearchEmployee(HttpServletRequest req) throws ClassNotFoundException, SQLException
{
	String employee_id=req.getParameter("employee_id");
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root",
			"admin1");
	Statement stmt=con.createStatement();
	String query="select * from employeemanagement.employee_table where employee_id='"+employee_id+"'";
	ResultSet rs=stmt.executeQuery(query);
	HashMap<String,Integer> map=new HashMap<String,Integer>();    
	while (rs.next())
	{ 
		map.put(rs.getString("name"),rs.getInt("employee_id"));
	}
	return map;
}

@PostMapping("/admin/searchByName")//admin
public HashMap SearchByName(HttpServletRequest req) throws ClassNotFoundException, SQLException
{
	String name=req.getParameter("name");
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/erp","root",
			"admin1");
	Statement stmt=con.createStatement();
	String query="select * from employeemanagement.employee_table where name='"+name+"'";
	ResultSet rs=stmt.executeQuery(query);
	HashMap<String,Integer> map=new HashMap<String,Integer>();    
	while (rs.next())
	{ 
		map.put(rs.getString("name"),rs.getInt("employee_id"));
	}
	return map;
}
}


