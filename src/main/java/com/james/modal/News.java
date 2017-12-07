package com.james.modal;

public class News {
	public String date;
	public String time;
	public String content;
	
	@Override
	public String toString() {
		return date + "\t" + time + "\t" + content;
	}
}
