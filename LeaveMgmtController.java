package com.codeplanet.codeplanet.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeplanet.codeplanet.modal.Leave;
import com.codeplanet.codeplanet.service.LeaveService;

@RestController
@RequestMapping("/leave")
public class LeaveMgmtController {

	@Autowired
	private LeaveService leaveService;

	@GetMapping("/report")
	public List<Map<String, Object>> getLeaveReport() throws ClassNotFoundException, SQLException {
		return leaveService.getLeaveReport();
	}

	@PostMapping("/save")
	public String saveleave(@RequestBody Leave leave) throws ClassNotFoundException, SQLException {
		return leaveService.saveleave(leave);
	}}