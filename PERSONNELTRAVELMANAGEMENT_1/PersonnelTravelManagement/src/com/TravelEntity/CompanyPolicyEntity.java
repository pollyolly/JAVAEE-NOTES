package com.TravelEntity;

public class CompanyPolicyEntity extends StatusEntity{

	private int policyid;
	private int expensedays;
	private double receiptamount;
	private double maxexpense;
	private double maxbudget;
	
	public double getMaxbudget() {
		return maxbudget;
	}
	public void setMaxbudget(double maxbudget) {
		this.maxbudget = maxbudget;
	}
	public CompanyPolicyEntity() {
		// TODO Auto-generated constructor stub
	}
	public double getReceiptamount() {
		return receiptamount;
	}

	public void setReceiptamount(double receiptamount) {
		this.receiptamount = receiptamount;
	}

	public double getMaxexpense() {
		return maxexpense;
	}

	public void setMaxexpense(double maxexpense) {
		this.maxexpense = maxexpense;
	}
	public int getPolicyid() {
		return policyid;
	}


	public void setPolicyid(int policyid) {
		this.policyid = policyid;
	}


	public int getExpensedays() {
		return expensedays;
	}


	public void setExpensedays(int expensedays) {
		this.expensedays = expensedays;
	}



}
