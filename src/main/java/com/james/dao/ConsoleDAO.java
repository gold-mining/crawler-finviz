package com.james.dao;

import java.util.List;

import com.james.modal.OverView;
import com.james.modal.StockDetailData;

public class ConsoleDAO {
	public static void output(StockDetailData data) {
		System.out.println(data);
	}
	
	public static void output(List<OverView> overViews) {
		for(int i = 0; i < overViews.size(); i++) {
			System.out.println(overViews.get(i));
		}
	}
}
