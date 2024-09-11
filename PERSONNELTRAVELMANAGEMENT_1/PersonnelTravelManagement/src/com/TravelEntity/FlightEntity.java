package com.TravelEntity;

public class FlightEntity extends TravelPlanListEntity{
	
	private String departure;
	private String returns;
	private int stopover;
	private String from;
	private String to;

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
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}	
}
