package com.app.erp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeListController {

	@PostMapping("/employeelist")
	public HashMap<Integer,String> employeelist1() throws ClassNotFoundException, SQLException 
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/erp","root","admin1");
	Statement stmt=con.createStatement();
	String fatchquery="select * from employee_table";
	ResultSet rs=stmt.executeQuery(fatchquery);
	HashMap<Integer,String> hm=new HashMap<Integer,String>();
	while(rs.next()) {
		hm.put(rs.getInt("employee_id"), rs.getString("name"));
}
	return hm;
	
}
}
