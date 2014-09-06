package com.google.swt.BeeApp3.server;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateHelper
{

	public DateHelper()
	{
		
	}
	
	public Date getGMTTimeStamp()
	{
		Date date = new Date();
		TimeZone tzGMT = TimeZone.getTimeZone("GMT");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.setTimeZone(tzGMT);
		return cal.getTime();
	}



}
