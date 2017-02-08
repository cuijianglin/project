package com.pbc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateUtils {
	public static Date StringToDate(String date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(StringUtils.isBlank(date))
		{
			return new Date();
		}
		else
		{
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
	public static String DateToString(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(date == null)
		{
			return sdf.format(new Date());
		}
		else
		{
			return sdf.format(date);
		}
	}
}
