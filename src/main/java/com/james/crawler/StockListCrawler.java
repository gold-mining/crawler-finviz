package com.james.crawler;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.james.modal.OverView;

import us.codecraft.xsoup.Xsoup;

public class StockListCrawler {
		
	public List<OverView> getStockList(int startPage, int endPage) throws Exception {
		try {
			List<OverView> overViews = new ArrayList<OverView>();
			for (int i = startPage; i <= endPage; i++) {
				overViews.addAll(getStockInOnePage(i));
			}
			return overViews;
		} catch (Exception e) {
			System.out.println("Get stock list fails");
			System.out.println(e.toString());
			return null;
		}
		
	}
	
	public List<OverView> getStockInOnePage(int pageNumber) throws Exception {
		List<OverView> overViews = new ArrayList<OverView>();
		Document document = Jsoup.connect("https://finviz.com/screener.ashx?v=111&o=-marketcap&r=" + ((pageNumber - 1) * 20 + 1)).get();
		
		for (int i = 2; i <= 21; i++) {
			Element row = Xsoup.compile("//*[@id=\"screener-content\"]/table/tbody/tr[4]/td/table/tbody/tr[" + i + "]").evaluate(document).getElements().get(0);
			OverView overView = getOverview(row);
			overViews.add(overView);
		}
		return overViews;
	}
	
	private OverView getOverview(Element row) {
		OverView overView = new OverView();
		
		overView.Ticker = Xsoup.compile("td[2]").evaluate(row).getElements().get(0).text();
		overView.Company = Xsoup.compile("td[3]").evaluate(row).getElements().get(0).text();
		overView.Sector = Xsoup.compile("td[4]").evaluate(row).getElements().get(0).text();
		overView.Industry = Xsoup.compile("td[5]").evaluate(row).getElements().get(0).text();
		overView.Country = Xsoup.compile("td[6]").evaluate(row).getElements().get(0).text();
		overView.MarketCap = setMarketCap(Xsoup.compile("td[7]").evaluate(row).getElements().get(0).text());
		
		return overView;
	}

	private String setMarketCap(String input) {
		input = input.trim();
		double baseNumber = Double.parseDouble(input.replace("B", "").replace("M", ""));
		double unit = input.contains("B") ? 1000000000 : 1000000;
		long marketCap = (long) (baseNumber * unit);
		return Long.toString(marketCap);
	}

}
