package com.TravelEntity;

public class ServicesEntity extends ServiceProviderEntity{

	private String service;
	private String description;
	private int serviceproviderid;
	private String type;
	private int typeid;
	private String serviceclass;
	private int classid;
	private double amount;
	
	public String getServiceclass() {
		return serviceclass;
	}

	public void setServiceclass(String serviceclass) {
		this.serviceclass = serviceclass;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ServicesEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getServiceproviderid() {
		return serviceproviderid;
	}

	public void setServiceproviderid(int serviceproviderid) {
		this.serviceproviderid = serviceproviderid;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
