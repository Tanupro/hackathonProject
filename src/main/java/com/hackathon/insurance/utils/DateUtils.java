package com.hackathon.insurance.utils;

import java.util.Date;

public class DateUtils {
	public static String dateFormatstamp(){
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}
}
