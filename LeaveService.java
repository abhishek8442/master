package com.codeplanet.codeplanet.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.codeplanet.codeplanet.modal.Leave;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

@Service
	public class LeaveService {
		
		public List<Map<String, Object>> getLeaveReport() throws ClassNotFoundException, SQLException {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "maa123");
			Statement stmt = con.createStatement();

			String query = "select* from applyleave";

			ResultSet rs1 = stmt.executeQuery(query);

			ResultSetMetaData data = (ResultSetMetaData) rs1.getMetaData();
			int count = data.getColumnCount();

			List<Map<String, Object>> map = new ArrayList<>();

			while (rs1.next()) {

				Map<String, Object> hashMap = new HashMap<>(count);
				for (int i = 1; i <= count; i++) {
					hashMap.put(data.getColumnName(i), rs1.getObject(i));
				}
				map.add(hashMap);
			}
			return map;
		}
			
			public String saveleave(Leave leave)  throws ClassNotFoundException, SQLException{
				
				String result = null;
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "maa123");

				String query = "insert  into applyleave (employee_id, employee_name , fromdate , Todate , numberofdays , Reason , PostingDate, status  ) values (?,?,?,?,?,?,?,?)";
				
				
				PreparedStatement pstmt = con .prepareStatement(query);
				
				
				pstmt.setInt(1, leave.getEmployeeId());
				pstmt.setString(2, leave.getEmployeeName());
				pstmt.setTimestamp(3, leave.getFromDate());
				pstmt.setTimestamp(4, leave.getToDate());
				pstmt.setInt(5,leave.getNumberOfDays());
				pstmt.setString(6,leave.getReason());
				pstmt.setTimestamp(7,leave.getPostingDate());
				pstmt.setString(8, leave.getStatus());				
				
				int response = pstmt.executeUpdate();
				
				if( response > 0) {
					result = "leave Record inserted successfully! ";
				}else {
					result = "Unable to insert the  Record successfully! ";
				}
				
				return result ;
				
			}
	
		}

	



