package com.james.modal;

public class OverView {
	public String Ticker;
	public String Company;
	public String Sector;
	public String Industry;
	public String Country;
	public String MarketCap;
	// public String P_E;
	// public String Price;
	// public String Change;
	// public String Volume;

	@Override
	public String toString() {
		return Ticker + "\t" + Company + "\t" + Sector + "\t" + Industry + "\t" + Country + "\t" + MarketCap;
		// + "\t" +
		// P_E + "\t" + Price + "\t" +
		// Change + "\t" + Volume;
	}
}
