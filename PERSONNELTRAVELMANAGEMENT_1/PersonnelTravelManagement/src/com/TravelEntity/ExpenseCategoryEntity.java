package com.TravelEntity;

public class ExpenseCategoryEntity extends DepartmentEntity{

	private int expensecatid;
	private String name;
	private double rate;
	//private String status;
	//private int statusid;
	
	public int getExpensecatid() {
		return expensecatid;
	}

	public void setExpensecatid(int expensecatid) {
		this.expensecatid = expensecatid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}


	/*public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStatusid() {
		return statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}*/

}
