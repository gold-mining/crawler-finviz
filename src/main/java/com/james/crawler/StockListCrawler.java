package com.james.crawler;

import java.io.File;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.james.modal.OverView;

import us.codecraft.xsoup.Xsoup;

public class StockListCrawler {
	
	private int startPage = 1;

	private int endPage = 200;
	
	private String output = ""; 
	
	private PrintWriter writer;
	
	public StockListCrawler() {
		super();
	}
	
	public StockListCrawler(int startPage, int endPage, String output) {
		super();
		this.startPage = startPage;
		this.endPage = endPage;
		this.output = output;
	}
	
	public void getStockList() throws Exception {
		new File(output).mkdirs();
		writer = new PrintWriter(output + "/result.txt", "UTF-8");
		for (int i = startPage; i <= endPage; i++) {
			String url = "https://finviz.com/screener.ashx?v=111&o=-marketcap&r=" + ((i - 1) * 20 + 1);
			getStockInOnePage(url, i);
		}
		writer.close();
	}
	
	public void getStockInOnePage(String pageURL, int pageNumber) throws Exception {
		Document document = Jsoup.connect(pageURL).get();
		
		for (int i = 2; i <= 21; i++) {
			Element row = Xsoup.compile("//*[@id=\"screener-content\"]/table/tbody/tr[4]/td/table/tbody/tr[" + i + "]").evaluate(document).getElements().get(0);
			OverView overView = getOverview(row);
			System.out.println(overView);
			writer.println(overView);
		}
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
