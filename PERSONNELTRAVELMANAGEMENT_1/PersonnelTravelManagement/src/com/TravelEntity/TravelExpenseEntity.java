package com.TravelEntity;

public class TravelExpenseEntity{

	private int id;
	private String tono;
	private String fromdate;
	private String todate;
	private String status;
	private int statusid;
	private String name;
	private String officername;
	private int officerid;
	private String destination;
	private double cashadvance;
	private double reimburse;
	private double nonreimburse;
	private double total;
	
	private String comment;
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getOfficerid() {
		return officerid;
	}
	public void setOfficerid(int officerid) {
		this.officerid = officerid;
	}
	public int getStatusid() {
		return statusid;
	}
	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}
	public double getCashadvance() {
		return cashadvance;
	}
	public void setCashadvance(double cashadvance) {
		this.cashadvance = cashadvance;
	}
	public double getReimburse() {
		return reimburse;
	}
	public void setReimburse(double reimburse) {
		this.reimburse = reimburse;
	}
	public double getNonreimburse() {
		return nonreimburse;
	}
	public void setNonreimburse(double nonreimburse) {
		this.nonreimburse = nonreimburse;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getOfficername() {
		return officername;
	}
	public void setOfficername(String officername) {
		this.officername = officername;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTono() {
		return tono;
	}
	public void setTono(String tono) {
		this.tono = tono;
	}
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
