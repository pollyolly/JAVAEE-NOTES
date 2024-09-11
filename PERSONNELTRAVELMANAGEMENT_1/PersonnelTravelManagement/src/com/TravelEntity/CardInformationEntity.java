package com.TravelEntity;

public class CardInformationEntity extends EmployeeInformationEntity{

	private int cardid;
	private String cardnumber;
	private int cardtypeid;
	private String cardtype;
	private int ownershipid;
	private String ownership;	
	private String expirydate;
	
	public String getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}

	public int getCardid() {
		return cardid;
	}

	public void setCardid(int cardid) {
		this.cardid = cardid;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public int getCardtypeid() {
		return cardtypeid;
	}

	public void setCardtypeid(int cardtypeid) {
		this.cardtypeid = cardtypeid;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public int getOwnershipid() {
		return ownershipid;
	}

	public void setOwnershipid(int ownershipid) {
		this.ownershipid = ownershipid;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

}
