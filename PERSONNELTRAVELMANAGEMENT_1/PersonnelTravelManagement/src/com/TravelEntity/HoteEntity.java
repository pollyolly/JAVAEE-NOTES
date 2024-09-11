package com.TravelEntity;

public class HoteEntity extends TravelPlanListEntity{
	
	private String checkin;
	private String checkout;
	
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

}
