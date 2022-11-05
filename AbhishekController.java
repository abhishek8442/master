package com.apply.india;

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

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbhishekController {
 





    @PostMapping("/admin/notice")
    public Map insertNotice(HttpServletRequest req) throws ClassNotFoundException, SQLException {
    String n=req.getParameter("notice");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","admin1");
	String query = "insert into notice(rel_time,notice) values(CURDATE(),?)";
	PreparedStatement stmt1=con.prepareStatement(query);
	
	stmt1.setString(1,n);
	int i=stmt1.executeUpdate();
	HashMap map=new HashMap();
	if(i>=1)
	{
		map.put("msg","Notice added");
		return map;
	}
	return map;
    }
    
    
    
    
    @GetMapping("/admin/delete")
    public Map deleteNotice(HttpServletRequest req) throws ClassNotFoundException, SQLException {
    String date=req.getParameter("rel_time");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","admin1");
	String query = "delete from notice where rel_time=?";
	PreparedStatement stmt1=con.prepareStatement(query);

	stmt1.setString(1,date);
	int i=stmt1.executeUpdate();
	HashMap map=new HashMap();
	if(i>=1)
	{
		map.put("msg","Notice deleted");
		return map;
	}
    return map;
    }
	
	
	
	@GetMapping("/admin/get_notice")
	public List showEmployee(HttpServletRequest req) throws ClassNotFoundException, SQLException {
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
	
	
	
	@GetMapping("/user/get_notice")
	public List showAdmin(HttpServletRequest req) throws ClassNotFoundException, SQLException {
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
	
	
	

	
	
	
	@PutMapping("/user/ChangePassword")
	public Map password(HttpServletRequest req) throws ClassNotFoundException, SQLException
	{
		String Email=req.getParameter("Email");
		String password=req.getParameter("password");
		String NewPassword=req.getParameter("newpassword");
		String ConfirmNewPassword=req.getParameter("confirmpassword");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","admin1");
		Statement stmt=con.createStatement();
		String query="select * from employee_table where Email='"+Email+"' or password='"+password+"'";
		ResultSet rs=stmt.executeQuery(query);
		HashMap map=new HashMap();
		if(rs.next())
		{
			if(rs.getString("Email").equals(Email))
			{
				if(rs.getString("password").equals(password))
				{
					String query1="update employee_table set password = ? where Email='"+Email+"'";
					PreparedStatement pstmt=con.prepareStatement(query1);
					pstmt.setString(1, NewPassword);
					if(NewPassword.equals(ConfirmNewPassword))
					{
						int i=pstmt.executeUpdate();
						if(i>=1)
							map.put("massage", "password change successfully");
						return map;
					}
					else
						map.put("massage", "newpassword and confirmpassword not same");
					return map;
				}
				else
					map.put("massage", "your password is wrong");
				return map;
			}
			else
				map.put("massage", "your email id is wrong");
			return map;
		}
		return map;
	}
}
	
	



