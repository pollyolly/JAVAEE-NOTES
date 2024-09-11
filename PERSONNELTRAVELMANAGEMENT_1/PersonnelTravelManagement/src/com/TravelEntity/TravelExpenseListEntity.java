package com.TravelEntity;

public class TravelExpenseListEntity {

	private int id;
	private String pcn;
	private String type;
	private int typeid;
	private int reimburse;
	private int billable;
	private double amount;
	private String date;
	private String reason;
	private String vendor;
	//Miscellaneous
	private String description;
	private String miscvendor;
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
	//meal
	private String mvendor;
	private String mdescription;
	//mileage
	private String mfrom;
	private String mto;
	private int distance;
	
	public String getMiscvendor() {
		return miscvendor;
	}
	public void setMiscvendor(String miscvendor) {
		this.miscvendor = miscvendor;
	}
	public String getMvendor() {
		return mvendor;
	}
	public void setMvendor(String mvendor) {
		this.mvendor = mvendor;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getMfrom() {
		return mfrom;
	}
	public void setMfrom(String mfrom) {
		this.mfrom = mfrom;
	}
	public String getMto() {
		return mto;
	}
	public void setMto(String mto) {
		this.mto = mto;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}	
	public String getPcn() {
		return pcn;
	}
	public void setPcn(String pcn) {
		this.pcn = pcn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public int getReimburse() {
		return reimburse;
	}
	public void setReimburse(int reimburse) {
		this.reimburse = reimburse;
	}
	public int getBillable() {
		return billable;
	}
	public void setBillable(int billable) {
		this.billable = billable;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getMdescription() {
		return mdescription;
	}
	public void setMdescription(String mdescription) {
		this.mdescription = mdescription;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
