package com.james.dao;

import java.io.PrintWriter;
import java.util.List;

import com.james.modal.OverView;
import com.james.modal.StockDetailData;

public class FileDAO {
	
	public static void output(StockDetailData data, String finalPath) {
		try {
			FileUtil.createDirectory(finalPath);
			PrintWriter writer = new PrintWriter(finalPath + "/" + data.ticker + ".txt", "UTF-8");
			writer.println(data);
			writer.close();
		} catch (Exception e) {
			System.out.println("Output data for " + data.ticker + " fail");
			System.out.println(e.toString());
		}
		
	}
	
	public static void output(List<OverView> overViews, String finalPath) {
		try {
			FileUtil.createDirectory(finalPath);
			PrintWriter writer = new PrintWriter(finalPath + "/result.txt", "UTF-8");
			for(int i = 0; i < overViews.size(); i++) {
				writer.println(overViews.get(i));
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("Output data for stock list fail");
			System.out.println(e.toString());
		}
	}
}