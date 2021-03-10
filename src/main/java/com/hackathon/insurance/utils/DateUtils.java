package com.hackathon.insurance.utils;

import java.util.Date;

public class DateUtils {
	public static Date date = null;
//	public String[] convertToXpath(String startDate,String endDate){
//		date = new Date();
//		String[] st = new String[2];
//		st[0] = "//*[@aria-label='Selected as start date. "+ date.toString() +"']"; 
//		return st;
//	}
	
	public static String dateFormatstamp(){
		date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}
}
