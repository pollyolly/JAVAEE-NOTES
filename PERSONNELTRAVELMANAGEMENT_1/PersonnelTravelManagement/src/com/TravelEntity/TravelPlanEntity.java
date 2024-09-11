package com.TravelEntity;

public class TravelPlanEntity extends TravelOrderEntity{

	private String fromdate;
	private double food;
	private double allowance;
	private double accommodation;
	private double transportation;
	private double perdiem;
	private double svtotal;
	private int planid;
	
	public int getPlanid() {
		return planid;
	}

	public void setPlanid(int planid) {
		this.planid = planid;
	}

	public double getSvtotal() {
		return svtotal;
	}

	public void setSvtotal(double svtotal) {
		this.svtotal = svtotal;
	}

	public double getFood() {
		return food;
	}

	public void setFood(double food) {
		this.food = food;
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}

	public double getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(double accommodation) {
		this.accommodation = accommodation;
	}

	public double getTransportation() {
		return transportation;
	}

	public void setTransportation(double transportation) {
		this.transportation = transportation;
	}

	public double getPerdiem() {
		return perdiem;
	}

	public void setPerdiem(double perdiem) {
		this.perdiem = perdiem;
	}
	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
}
