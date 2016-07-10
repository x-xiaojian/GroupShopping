package com.tg.tools;

import java.util.Date;
import java.text.DateFormat;

public class CountTime {
	public String currentlyTime() {
		Date date = new Date();         //ÊµÀý»¯DateÀà
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		return dateFormat.format(date);
	}
}
