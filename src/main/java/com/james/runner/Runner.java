package com.james.runner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.james.crawler.StockDetailCrawler;
import com.james.crawler.StockListCrawler;
import com.james.dao.ConsoleDAO;
import com.james.dao.FileDAO;
import com.james.dao.FileUtil;
import com.james.modal.OverView;
import com.james.modal.StockDetailData;

public class Runner {
	
	public static void main(String[] args) throws Exception {	
		Date date1 = new Date();

		Map<String, String> input = new HashMap<String, String>();
		for (int i = 0; i < args.length; i++) {
			String[] parts = args[i].trim().split("=");
			input.put(parts[0], parts[1]);
			System.out.println(parts[0] + ": " + parts[1]);
		}

		Runner runner = new Runner();
		
		switch (input.get("mode")) {
			case "list-stock": runner.getStockList(input.get("start"), input.get("stop"), input.get("output")); break;
			case "all-stock-detail": runner.getAllStockDetail(input.get("stock-list"), input.get("output")); break;
			case "all-stock-detail-multithread": runner.getAllStockDetail(input.get("stock-list"), input.get("output"), input.get("thread")); break;
			default: break;
		}

		Date date2 = new Date();
		System.out.println(date2.getTime() - date1.getTime());
	}
	
	public void getStockList(String start, String stop, String output) throws Exception {
		if (output != null && FileUtil.isFileExist(output + "/result.txt")) return;
		StockListCrawler crawler = new StockListCrawler();
		List<OverView> overViews = crawler.getStockList(Integer.parseInt(start), Integer.parseInt(stop));
		ConsoleDAO.output(overViews, true);
		FileDAO.output(overViews, output);
	}

	public void getAllStockDetail(String stockList, String output) {
		Queue<String> queue = FileUtil.getStockListFromFile(stockList);

		while (!queue.isEmpty()) {
			StockDetailRunner runner = new StockDetailRunner(queue.poll(), output);
			runner.run();
		}
	}

	public void getAllStockDetail(String stockList, String output, String threadNumber) {
		try {
			Queue<String> queue = FileUtil.getStockListFromFile(stockList);
			
			ExecutorService executor = Executors.newFixedThreadPool(Integer.parseInt(threadNumber));

			while (!queue.isEmpty()) {
				StockDetailRunner runner = new StockDetailRunner(queue.poll(), output);
				executor.execute(runner);
			}

			executor.shutdown();
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	class StockDetailRunner implements Runnable {
		
		private String ticker;
		
		private String location;
		
		public StockDetailRunner(String ticker, String location) {
			this.ticker = ticker;
			this.location = location;
		}

		@Override
		public void run() {
			if (FileUtil.isFileExist(location + "/" + ticker + ".txt")) return;
			
			StockDetailCrawler crawler = new StockDetailCrawler();
			StockDetailData data = crawler.getDetailInfo(ticker);
			ConsoleDAO.output(data, true);
			FileDAO.output(data, location);
		}
		
	}

}
