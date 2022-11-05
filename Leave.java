package com.codeplanet.codeplanet.modal;

import java.sql.Timestamp;

public class Leave {

	private int employeeId;
	private String employeeName;
	private Timestamp fromDate;
	private Timestamp toDate;
	private Integer numberOfDays;
	private String reason;
	private Timestamp postingDate;
	private String status;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Timestamp getFromDate() {
		return fromDate;
	}

	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}

	public Timestamp getToDate() {
		return toDate;
	}

	public void setToDate(Timestamp toDate) {
		this.toDate = toDate;
	}

	public Integer getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(Integer numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Timestamp getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(Timestamp postingDate) {
		this.postingDate = postingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Leave [employeeId=" + employeeId + ", employeeName=" + employeeName + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", numberOfDays=" + numberOfDays + ", reason=" + reason + ", postingDate="
				+ postingDate + ", status=" + status + "]";
	}

}
