package com.james.dao;

import java.util.List;

import com.james.modal.OverView;
import com.james.modal.StockDetailData;

public class ConsoleDAO {
	public static void output(StockDetailData data, boolean brief) {
		if (brief) System.out.println(data.ticker); 
		else System.out.println(data);
	}
	
	public static void output(List<OverView> overViews, boolean brief) {
		for(int i = 0; i < overViews.size(); i++) {
			if (brief) System.out.println(overViews.get(i).Ticker);
			else System.out.println(overViews.get(i));
		}
	}
}
