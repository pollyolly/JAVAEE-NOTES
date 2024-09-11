package com.HelperClasses;

public class Helper {

	public Helper() {
		// TODO Auto-generated constructor stub
	}
	public int toInt(String val){
		int toint=0;
		if(val.trim().length() > 0 || val != null){
			toint =  Integer.valueOf(val);	
		} else {System.out.print("\n Message: Empty parameter");}
		return toint;
	}
	public double toDouble(String val){
		double vals = 0;
		if(val.trim().length() > 0 || val != null){
		vals = Double.parseDouble(val);
		} else {System.out.print("\n Message: Empty paramete");}
		return vals;
	}
	public String toString(String val){
		String vals="";
		if(val.trim().length() > 0 || val != null){
			vals = String.valueOf(val);
			} else {System.out.print("\n Message: Empty parameter");}
		
		return vals;
	}
}
