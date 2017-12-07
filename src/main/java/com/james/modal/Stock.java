package com.james.modal;

import java.util.List;

public class Stock {
	public OverView overView;
	public BasicStatistic basicStatistic;
	public List<RatingOuter> ratingOuter;
	public List<News> news;
	public List<Insider> insider;
	
	public void output() {
		
		System.out.println("---");
		System.out.println(overView.Ticker);
		
		System.out.println("\t" + overView);
//		System.out.println("\t" + basicStatistic);
//		
//		for (RatingOuter singleRatingOuter : ratingOuter) {
//			System.out.println("\t" + singleRatingOuter);
//		}
//		
//		for (News singleNews : news) {
//			System.out.println("\t" + singleNews);
//		}
//		
//		for (Insider singleInsider : insider) {
//			System.out.println("\t" + singleInsider);
//		}
	}
}
