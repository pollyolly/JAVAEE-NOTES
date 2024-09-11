package com.TravelEntity;

public class ApprovingOfficerEntity extends EmployeeInformationEntity{

	private int officerid;
	private String description;
	
	public ApprovingOfficerEntity() {
		// TODO Auto-generated constructor stub		
	}
	public int getOfficerid() {
		return officerid;
	}


	public void setOfficerid(int officerid) {
		this.officerid = officerid;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


}
