package com.james.modal;

public class Insider {
	public String name;
	public String relationShip;
	public String date;
	public String transaction;
	public String cost;
	public String shares;
	public String value;
	public String sharesTotal;
	public String total;
	
	@Override
	public String toString() {
		return name + "\t" + relationShip + "\t" + date + "\t" + transaction + "\t" + cost + "\t" + shares + "\t" + value + "\t" + sharesTotal + "\t" + total;
	}
}
