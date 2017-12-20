package com.james.modal;

import java.util.List;

public class StockDetailData {
	public String ticker;
	public BasicStatistic basicStatistic;
	public List<RatingOuter> ratingOuters;
	public List<News> news;
	public List<Insider> insiders;
	
	@Override
	public String toString() {
		String output = "";
		
		output += ticker + "\n";
		
		output += "\tBasic Information:" + "\n";
		output += "\t\t" + BasicStatistic.markers() + "\n";
		output += "\t\t" + basicStatistic.toString() + "\n";
		output += "\t\t" + basicStatistic.toString() + "\n";
		
		if (ratingOuters != null && ratingOuters.size() > 0) {
			output += "\tRating:" + "\n";
			output += "\t\t" + RatingOuter.markers() + "\n";
			for (int i = 0; i < ratingOuters.size(); i++) {
				output += "\t\t" + ratingOuters.get(i).toString() + "\n";
			}
		}
		
		if (news != null && news.size() > 0) {
			output += "\tNews:" + "\n";
			output += "\t\t" + News.markers() + "\n";
			for (int i = 0; i < news.size(); i++) {
				output += "\t\t" + news.get(i).toString() + "\n";
			}
		}
		
		if (insiders != null && insiders.size() > 0) {
			output += "\tInsiders Trading:" + "\n";
			output += "\t\t" + Insider.markers() + "\n";
			for (int i = 0; i < insiders.size(); i++) {
				output += "\t\t" + insiders.get(i).toString() + "\n";
			}
		}
		
		return output;
	}
}
