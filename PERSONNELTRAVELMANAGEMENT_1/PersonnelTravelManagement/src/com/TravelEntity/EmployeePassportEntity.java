package com.TravelEntity;

public class EmployeePassportEntity extends EmployeeInformationEntity{

	private String passportno;
	private String expirydate;
	private int passportid;
	
	public int getPassportid() {
		return passportid;
	}

	public void setPassportid(int passportid) {
		this.passportid = passportid;
	}

	public EmployeePassportEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public String getPassportno() {
		return passportno;
	}

	public void setPassportno(String passportno) {
		this.passportno = passportno;
	}

	public String getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
}
