package com.app.erp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController		
public class AttendanceController {
	@PostMapping("/admin/attendance")
		public boolean attendence(HttpServletRequest obj) throws ClassNotFoundException, SQLException 
	{
		String employee_id=obj.getParameter("employee_id");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","admin1");
		Statement stmt=con.createStatement();
		String fatchquery="select attendance from employee_table where employee_id='"+employee_id+"'";
		ResultSet rs=stmt.executeQuery(fatchquery);
		rs.next();
		int attendance =rs.getInt("attendance")+1;
		String insertquery="update employee_table set attendance= "+attendance+" "+"where employee_id ="+employee_id+';';
		int re=stmt.executeUpdate(insertquery);
		if(re==1)
			return true;
		else
			return false;
	}
}