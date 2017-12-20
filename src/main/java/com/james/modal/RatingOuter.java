package com.james.modal;

public class RatingOuter {
	public String date;
	public String rating;
	public String institution;
	public String action;
	public String targetPrice;
	
	@Override
	public String toString() {
		return date + "\t" + rating + "\t" + institution + "\t" + action + "\t" + targetPrice + "\t";
	}
	
	public static String markers() {
		return "date" + "\t" + "rating" + "\t" + "institution" + "\t" + "action" + "\t" + "targetPrice";
	}
}
