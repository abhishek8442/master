package com.app.erp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeListController {

	@PostMapping("/admin/employeelist")
	public ArrayList employeelist1() throws ClassNotFoundException, SQLException 
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/erp","root","admin1");
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
}
