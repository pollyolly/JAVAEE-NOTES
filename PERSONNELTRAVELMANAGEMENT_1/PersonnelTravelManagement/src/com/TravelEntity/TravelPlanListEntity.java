package com.TravelEntity;

import java.util.Collection;

public class TravelPlanListEntity extends TravelOrderEntity{

	private String planid;
	private String pcn;
	private String serviceprovider;
	private int serviceproviderid;
	private String service;
	private int serviceid;
	private String type;
	private int typeid;
	private String file;
	private double amount;
	private double miscamount;
	//Miscellaneous
	private String description;
	private String vendor;
	//Car
	private String cfrom;
	private String cto;
	private String pickup;
	private String dropoff;
	//Hotel
	private String checkin;
	private String checkout;
	//Flight
	private String departure;
	private String returns;
	private int stopover;
	private String ffrom;
	private String fto;
	
	private Collection names;
	
	public String getPlanid() {
		return planid;
	}
	public void setPlanid(String planid) {
		this.planid = planid;
	}
	
	public Collection getNames() {
		return names;
	}
	public void setNames(Collection names) {
		this.names = names;
	}
	
	public String getFfrom() {
		return ffrom;
	}
	public void setFfrom(String ffrom) {
		this.ffrom = ffrom;
	}
	public String getFto() {
		return fto;
	}
	public void setFto(String fto) {
		this.fto = fto;
	}
	public double getMiscamount() {
		return miscamount;
	}
	public void setMiscamount(double miscamount) {
		this.miscamount = miscamount;
	}
	public String getCfrom() {
		return cfrom;
	}
	public void setCfrom(String cfrom) {
		this.cfrom = cfrom;
	}
	public String getCto() {
		return cto;
	}
	public void setCto(String cto) {
		this.cto = cto;
	}
	public String getServiceprovider() {
		return serviceprovider;
	}
	public void setServiceprovider(String serviceprovider) {
		this.serviceprovider = serviceprovider;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	/*
	public String getCfrom() {
		return cfrom;
	}
	public void setCfrom(String cfrom) {
		this.cfrom = cfrom;
	}
	public String getCto() {
		return cto;
	}
	public void setCto(String cto) {
		this.cto = cto;
	}
	*/
	public String getPickup() {
		return pickup;
	}
	public void setPickup(String pickup) {
		this.pickup = pickup;
	}
	public String getDropoff() {
		return dropoff;
	}
	public void setDropoff(String dropoff) {
		this.dropoff = dropoff;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getReturns() {
		return returns;
	}
	public void setReturns(String returns) {
		this.returns = returns;
	}
	public int getStopover() {
		return stopover;
	}
	public void setStopover(int stopover) {
		this.stopover = stopover;
	}
	/*
	public String getFfrom() {
		return ffrom;
	}
	public void setFfrom(String ffrom) {
		this.ffrom = ffrom;
	}
	public String getFto() {
		return fto;
	}
	public void setFto(String fto) {
		this.fto = fto;
	}	
	*/
	public String getPcn() {
		return pcn;
	}
	public void setPcn(String pcn) {
		this.pcn = pcn;
	}
	public int getServiceproviderid() {
		return serviceproviderid;
	}
	public void setServiceproviderid(int serviceproviderid) {
		this.serviceproviderid = serviceproviderid;
	}
	public int getServiceid() {
		return serviceid;
	}
	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
