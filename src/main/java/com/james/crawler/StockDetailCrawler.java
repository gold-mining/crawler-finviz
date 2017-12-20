package com.james.crawler;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.james.modal.BasicStatistic;
import com.james.modal.Insider;
import com.james.modal.News;
import com.james.modal.RatingOuter;

import us.codecraft.xsoup.Xsoup;

public class StockDetailCrawler {

	private String ticker = "";

	private String finalOutPath = "";

	private PrintWriter writer;

	public StockDetailCrawler() {
		super();
	}

	public boolean initCrawler(String ticker, String date, String output) {
		this.ticker = ticker;
		this.finalOutPath = output + "/" + date;
		if (isFileExist()) return false;

		try {
			new File(finalOutPath).mkdirs();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void getDetailInfo() {
		try {
			Document document = Jsoup.connect("https://finviz.com/quote.ashx?t=" + this.ticker + "&ty=c&p=d&b=1").get();
			this.writer = new PrintWriter(finalOutPath + "/" + this.ticker + ".txt", "UTF-8");
			
			BasicStatistic basicStatistic = getBasicStatistic(document);
			List<RatingOuter> ratingOuters = getRatingOuter(document);
			List<News> news = getNews(document);
			List<Insider> insiders = getInsider(document);
			outpuResult(basicStatistic, ratingOuters, news, insiders);
			this.writer.close();
		} catch (Exception e) {
			System.out.println(this.ticker);
			System.out.println(e.toString());
		}
	}

	private BasicStatistic getBasicStatistic(Document document) {
		BasicStatistic basicStatistic = new BasicStatistic();
		Element basicStatisticSection = Xsoup.compile("/html/body/table[3]/tbody/tr[7]/td/table").evaluate(document).getElements().get(0);
				
		basicStatistic.Index = Xsoup.compile("tbody/tr[1]/td[2]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.MarketCap = Xsoup.compile("tbody/tr[2]/td[2]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Income = Xsoup.compile("tbody/tr[3]/td[2]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Sales = Xsoup.compile("tbody/tr[4]/td[2]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Book_sh = Xsoup.compile("tbody/tr[5]/td[2]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Cash_sh = Xsoup.compile("tbody/tr[6]/td[2]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Dividend = Xsoup.compile("tbody/tr[7]/td[2]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Dividend_percentage = Xsoup.compile("tbody/tr[8]/td[2]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Employees = Xsoup.compile("tbody/tr[9]/td[2]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Optionable = Xsoup.compile("tbody/tr[10]/td[2]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Shortable = Xsoup.compile("tbody/tr[11]/td[2]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Recom = Xsoup.compile("tbody/tr[12]/td[2]").evaluate(basicStatisticSection).getElements().get(0).text();

		basicStatistic.P_E = Xsoup.compile("tbody/tr[1]/td[4]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Forward_P_E = Xsoup.compile("tbody/tr[2]/td[4]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.PEG = Xsoup.compile("tbody/tr[3]/td[4]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.P_S = Xsoup.compile("tbody/tr[4]/td[4]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.P_B = Xsoup.compile("tbody/tr[5]/td[4]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.P_C = Xsoup.compile("tbody/tr[6]/td[4]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.P_FCF = Xsoup.compile("tbody/tr[7]/td[4]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Quick_Ratio = Xsoup.compile("tbody/tr[8]/td[4]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Current_Ratio = Xsoup.compile("tbody/tr[9]/td[4]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Debt_Eq = Xsoup.compile("tbody/tr[10]/td[4]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.LT_Debt_Eq = Xsoup.compile("tbody/tr[11]/td[4]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.SMA20 = Xsoup.compile("tbody/tr[12]/td[4]").evaluate(basicStatisticSection).getElements().get(0).text();

		basicStatistic.EPS_ttm = Xsoup.compile("tbody/tr[1]/td[6]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.EPS_next_Y_num = Xsoup.compile("tbody/tr[2]/td[6]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.EPS_next_Q = Xsoup.compile("tbody/tr[3]/td[6]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.EPS_this_Y = Xsoup.compile("tbody/tr[4]/td[6]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.EPS_next_Y_percentage = Xsoup.compile("tbody/tr[5]/td[6]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.EPS_next_5Y = Xsoup.compile("tbody/tr[6]/td[6]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.EPS_past_5Y = Xsoup.compile("tbody/tr[7]/td[6]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Sales_past_5Y = Xsoup.compile("tbody/tr[8]/td[6]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Sales_Q_Q = Xsoup.compile("tbody/tr[9]/td[6]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.EPS_Q_Q = Xsoup.compile("tbody/tr[10]/td[6]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Earnings = Xsoup.compile("tbody/tr[11]/td[6]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.SMA50 = Xsoup.compile("tbody/tr[12]/td[6]").evaluate(basicStatisticSection).getElements().get(0).text();

		basicStatistic.Insider_Own = Xsoup.compile("tbody/tr[1]/td[8]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Insider_Trans = Xsoup.compile("tbody/tr[2]/td[8]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Inst_Own = Xsoup.compile("tbody/tr[3]/td[8]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Inst_Trans = Xsoup.compile("tbody/tr[4]/td[8]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.ROA = Xsoup.compile("tbody/tr[5]/td[8]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.ROE = Xsoup.compile("tbody/tr[6]/td[8]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.ROI = Xsoup.compile("tbody/tr[7]/td[8]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Gross_Margin = Xsoup.compile("tbody/tr[8]/td[8]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Oper_Margin = Xsoup.compile("tbody/tr[9]/td[8]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Profit_Margin = Xsoup.compile("tbody/tr[10]/td[8]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Payout = Xsoup.compile("tbody/tr[11]/td[8]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.SMA200 = Xsoup.compile("tbody/tr[12]/td[8]").evaluate(basicStatisticSection).getElements().get(0).text();

		basicStatistic.Shs_Outstand = Xsoup.compile("tbody/tr[1]/td[10]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Shs_Float = Xsoup.compile("tbody/tr[2]/td[10]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Short_Float = Xsoup.compile("tbody/tr[3]/td[10]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Short_Ratio = Xsoup.compile("tbody/tr[4]/td[10]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Target_Price = Xsoup.compile("tbody/tr[5]/td[10]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.W52_Range = Xsoup.compile("tbody/tr[6]/td[10]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.W52_High = Xsoup.compile("tbody/tr[7]/td[10]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.W52_Low = Xsoup.compile("tbody/tr[8]/td[10]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.RSI = Xsoup.compile("tbody/tr[9]/td[10]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Rel_Volume = Xsoup.compile("tbody/tr[10]/td[10]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Avg_Volume = Xsoup.compile("tbody/tr[11]/td[10]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Volume = Xsoup.compile("tbody/tr[12]/td[10]").evaluate(basicStatisticSection).getElements().get(0).text();

		basicStatistic.Perf_Week = Xsoup.compile("tbody/tr[1]/td[12]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Perf_Month = Xsoup.compile("tbody/tr[2]/td[12]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Perf_Quarter = Xsoup.compile("tbody/tr[3]/td[12]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Perf_Half_Y = Xsoup.compile("tbody/tr[4]/td[12]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Perf_Year = Xsoup.compile("tbody/tr[5]/td[12]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Perf_YTD = Xsoup.compile("tbody/tr[6]/td[12]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Beta = Xsoup.compile("tbody/tr[7]/td[12]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.ATR = Xsoup.compile("tbody/tr[8]/td[12]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Volatility = Xsoup.compile("tbody/tr[9]/td[12]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Prev_Close = Xsoup.compile("tbody/tr[10]/td[12]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Price = Xsoup.compile("tbody/tr[11]/td[12]").evaluate(basicStatisticSection).getElements().get(0).text();
		basicStatistic.Change = Xsoup.compile("tbody/tr[12]/td[12]").evaluate(basicStatisticSection).getElements().get(0).text();

		return basicStatistic;
	}

	private List<RatingOuter> getRatingOuter(Document document) {
		List<RatingOuter> ratingOuters = new ArrayList<RatingOuter>();
		
		Elements allRatings = Xsoup.compile("//*[@class=\"fullview-ratings-outer\"]/tbody/tr").evaluate(document).getElements();
		
		for (int i = 0; i < allRatings.size(); i++) {
			RatingOuter ratingOuter = new RatingOuter();
			ratingOuter.date = Xsoup.compile("td/table/tbody/tr/td[1]").evaluate(allRatings.get(i)).getElements().get(0).text();
			ratingOuter.rating = Xsoup.compile("td/table/tbody/tr/td[2]").evaluate(allRatings.get(i)).getElements().get(0).text();
			ratingOuter.institution = Xsoup.compile("td/table/tbody/tr/td[3]").evaluate(allRatings.get(i)).getElements().get(0).text();
			ratingOuter.action = Xsoup.compile("td/table/tbody/tr/td[4]").evaluate(allRatings.get(i)).getElements().get(0).text();
			ratingOuter.targetPrice = Xsoup.compile("td/table/tbody/tr/td[5]").evaluate(allRatings.get(i)).getElements().get(0).text();
			ratingOuters.add(ratingOuter);
		}

		return ratingOuters;
	}

	private List<News> getNews(Document document) {
		List<News> newses = new ArrayList<News>();
		
		Elements allNews = Xsoup.compile("//*[@id=\"news-table\"]/tbody/tr").evaluate(document).getElements();
		String preDate = null;

		for (int i = 0; i < allNews.size(); i++) {
			News news = new News();

			String dateTime = Xsoup.compile("td[1]").evaluate(allNews.get(i)).getElements().get(0).text();
			String date = (dateTime.split(" ").length > 1) ? dateTime.split(" ")[0] : preDate;
			String time = (dateTime.split(" ").length > 1) ? dateTime.split(" ")[1] : dateTime.split(" ")[0];
			preDate = date;

			news.date = date;
			news.time = time;
			news.content = Xsoup.compile("td[2]").evaluate(allNews.get(i)).getElements().get(0).text();;
			newses.add(news);
		}
		return newses;
	}

	private List<Insider> getInsider(Document document) {
		List<Insider> insiders = new ArrayList<Insider>();
		
		Elements allInsiders = Xsoup.compile("//*[@class=\"insider-sale-row-2\"]").evaluate(document).getElements();

		for (int i = 0; i < allInsiders.size(); i++) {
			Insider insider = new Insider();

			insider.name = Xsoup.compile("td[1]").evaluate(allInsiders.get(i)).getElements().get(0).text();
			insider.relationShip = Xsoup.compile("td[2]").evaluate(allInsiders.get(i)).getElements().get(0).text();
			insider.date = Xsoup.compile("td[3]").evaluate(allInsiders.get(i)).getElements().get(0).text();
			insider.transaction = Xsoup.compile("td[4]").evaluate(allInsiders.get(i)).getElements().get(0).text();
			insider.cost = Xsoup.compile("td[5]").evaluate(allInsiders.get(i)).getElements().get(0).text();
			insider.shares = Xsoup.compile("td[6]").evaluate(allInsiders.get(i)).getElements().get(0).text();
			insider.value = Xsoup.compile("td[7]").evaluate(allInsiders.get(i)).getElements().get(0).text();
			insider.sharesTotal = Xsoup.compile("td[8]").evaluate(allInsiders.get(i)).getElements().get(0).text();
			insider.total = Xsoup.compile("td[9]").evaluate(allInsiders.get(i)).getElements().get(0).text();

			insiders.add(insider);
		}

		return insiders;
	}
	
	private void outpuResult(BasicStatistic basicStatistic, List<RatingOuter> ratingOuters, List<News> news, List<Insider> insiders) {
		ratingOuters = (ratingOuters == null) ? new ArrayList<RatingOuter>() : ratingOuters;
		news = (news == null) ? new ArrayList<News>() : news;
		insiders = (insiders == null) ? new ArrayList<Insider>() : insiders;
		
//		outpuResultToConsole(basicStatistic, ratingOuters, news, insiders);
		outpuResultToFiles(basicStatistic, ratingOuters, news, insiders);
	}
	
	private void outpuResultToFiles(BasicStatistic basicStatistic, List<RatingOuter> ratingOuters, List<News> news, List<Insider> insiders) {
		writer.println(this.ticker);
		writer.println("\t basic statistic");
		writer.println("\t\t" + BasicStatistic.markers());
		writer.println("\t\t" + basicStatistic);
		
		writer.println("\t rating");
		for(RatingOuter ratingOuter: ratingOuters) writer.println("\t\t" + ratingOuter);
		
		writer.println("\t news");
		for(News singleNews: news) writer.println("\t\t" + singleNews);
		
		writer.println("\t inside trading");
		for(Insider insider: insiders) writer.println("\t\t" + insider);
	}
	
	private void outpuResultToConsole(BasicStatistic basicStatistic, List<RatingOuter> ratingOuters, List<News> news, List<Insider> insiders) {
		System.out.println(this.ticker);
		System.out.println("\t basic statistic");
		System.out.println("\t\t" + BasicStatistic.markers());
		System.out.println("\t\t" + basicStatistic);
		
		System.out.println("\t rating");
		for(RatingOuter ratingOuter: ratingOuters) System.out.println("\t\t" + ratingOuter);
		
		System.out.println("\t news");
		for(News singleNews: news) System.out.println("\t\t" + singleNews);
		
		System.out.println("\t inside trading");
		for(Insider insider: insiders) System.out.println("\t\t" + insider);
		
		System.out.println();
		System.out.println();
	}

	private boolean isFileExist() {
		File file = new File(finalOutPath + "/" + this.ticker + ".txt");
		return file.exists() && file.length() != 0;
	}

}
