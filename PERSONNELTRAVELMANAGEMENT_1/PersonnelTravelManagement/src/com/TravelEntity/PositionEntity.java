package com.TravelEntity;

public class PositionEntity extends StatusEntity{

	private int positionid;
	private String position;
	private String description;
	
	public PositionEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public int getPositionid() {
		return positionid;
	}

	public void setPositionid(int positionid) {
		this.positionid = positionid;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
