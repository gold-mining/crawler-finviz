package com.james.modal;

public class BasicStatistic {
	public String Index;
	public String MarketCap;
	public String Income;
	public String Sales;
	public String Book_sh;
	public String Cash_sh;
	public String Dividend;
	public String Dividend_percentage;
	public String Employees;
	public String Optionable;
	public String Shortable;
	public String Recom;
	public String P_E;
	public String Forward_P_E;
	public String PEG;
	public String P_S;
	public String P_B;
	public String P_C;
	public String P_FCF;
	public String Quick_Ratio;
	public String Current_Ratio;
	public String Debt_Eq;
	public String LT_Debt_Eq;
	public String SMA20;
	public String EPS_ttm;
	public String EPS_next_Y_num;
	public String EPS_next_Q;
	public String EPS_this_Y;
	public String EPS_next_Y_percentage;
	public String EPS_next_5Y;
	public String EPS_past_5Y;
	public String Sales_past_5Y;
	public String Sales_Q_Q;
	public String EPS_Q_Q;
	public String Earnings;
	public String SMA50;
	public String Insider_Own;
	public String Insider_Trans;
	public String Inst_Own;
	public String Inst_Trans;
	public String ROA;
	public String ROE;
	public String ROI;
	public String Gross_Margin;
	public String Oper_Margin;
	public String Profit_Margin;
	public String Payout;
	public String SMA200;
	public String Shs_Outstand;
	public String Shs_Float;
	public String Short_Float;
	public String Short_Ratio;
	public String Target_Price;
	public String W52_Range;
	public String W52_High;
	public String W52_Low;
	public String RSI;
	public String Rel_Volume;
	public String Avg_Volume;
	public String Volume;
	public String Perf_Week;
	public String Perf_Month;
	public String Perf_Quarter;
	public String Perf_Half_Y;
	public String Perf_Year;
	public String Perf_YTD;
	public String Beta;
	public String ATR;
	public String Volatility;
	public String Prev_Close;
	public String Price;
	public String Change;
	
	@Override
	public String toString() {
		return Index + "\t" + MarketCap + "\t" + Income + "\t" + Sales + "\t" + Book_sh + "\t" + Cash_sh + "\t" + Dividend + "\t" + Dividend_percentage + "\t" + Employees + "\t" + Optionable + "\t" + Shortable + "\t" + Recom + "\t" + P_E + "\t" + Forward_P_E + "\t" + PEG + "\t" + P_S + "\t" + P_B + "\t" + P_C + "\t" + P_FCF + "\t" + Quick_Ratio + "\t" + Current_Ratio + "\t" + Debt_Eq + "\t" + LT_Debt_Eq + "\t" + SMA20 + "\t" + EPS_ttm + "\t" + EPS_next_Y_num + "\t" + EPS_next_Q + "\t" + EPS_this_Y + "\t" + EPS_next_Y_percentage + "\t" + EPS_next_5Y + "\t" + EPS_past_5Y + "\t" + Sales_past_5Y + "\t" + Sales_Q_Q + "\t" + EPS_Q_Q + "\t" + Earnings + "\t" + SMA50 + "\t" + Insider_Own + "\t" + Insider_Trans + "\t" + Inst_Own + "\t" + Inst_Trans + "\t" + ROA + "\t" + ROE + "\t" + ROI + "\t" + Gross_Margin + "\t" + Oper_Margin + "\t" + Profit_Margin + "\t" + Payout + "\t" + SMA200 + "\t" + Shs_Outstand + "\t" + Shs_Float + "\t" + Short_Float + "\t" + Short_Ratio + "\t" + Target_Price + "\t" + W52_Range + "\t" + W52_High + "\t" + W52_Low + "\t" + RSI + "\t" + Rel_Volume + "\t" + Avg_Volume + "\t" + Volume + "\t" + Perf_Week + "\t" + Perf_Month + "\t" + Perf_Quarter + "\t" + Perf_Half_Y + "\t" + Perf_Year + "\t" + Perf_YTD + "\t" + Beta + "\t" + ATR + "\t" + Volatility + "\t" + Prev_Close + "\t" + Price + "\t" + Change;
	}
	
	public static String markers() {
		return "Index" + "\t" + "MarketCap" + "\t" + "Income" + "\t" + "Sales" + "\t" + "Book_sh" + "\t" + "Cash_sh" + "\t" + "Dividend" + "\t" + "Dividend_percentage" + "\t" + "Employees" + "\t" + "Optionable" + "\t" + "Shortable" + "\t" + "Recom" + "\t" + "P_E" + "\t" + "Forward_P_E" + "\t" + "PEG" + "\t" + "P_S" + "\t" + "P_B" + "\t" + "P_C" + "\t" + "P_FCF" + "\t" + "Quick_Ratio" + "\t" + "Current_Ratio" + "\t" + "Debt_Eq" + "\t" + "LT_Debt_Eq" + "\t" + "SMA20" + "\t" + "EPS_ttm" + "\t" + "EPS_next_Y_num" + "\t" + "EPS_next_Q" + "\t" + "EPS_this_Y" + "\t" + "EPS_next_Y_percentage" + "\t" + "EPS_next_5Y" + "\t" + "EPS_past_5Y" + "\t" + "Sales_past_5Y" + "\t" + "Sales_Q_Q" + "\t" + "EPS_Q_Q" + "\t" + "Earnings" + "\t" + "SMA50" + "\t" + "Insider_Own" + "\t" + "Insider_Trans" + "\t" + "Inst_Own" + "\t" + "Inst_Trans" + "\t" + "ROA" + "\t" + "ROE" + "\t" + "ROI" + "\t" + "Gross_Margin" + "\t" + "Oper_Margin" + "\t" + "Profit_Margin" + "\t" + "Payout" + "\t" + "SMA200" + "\t" + "Shs_Outstand" + "\t" + "Shs_Float" + "\t" + "Short_Float" + "\t" + "Short_Ratio" + "\t" + "Target_Price" + "\t" + "W52_Range" + "\t" + "W52_High" + "\t" + "W52_Low" + "\t" + "RSI" + "\t" + "Rel_Volume" + "\t" + "Avg_Volume" + "\t" + "Volume" + "\t" + "Perf_Week" + "\t" + "Perf_Month" + "\t" + "Perf_Quarter" + "\t" + "Perf_Half_Y" + "\t" + "Perf_Year" + "\t" + "Perf_YTD" + "\t" + "Beta" + "\t" + "ATR" + "\t" + "Volatility" + "\t" + "Prev_Close" + "\t" + "Price" + "\t" + "Change";
	}
}
