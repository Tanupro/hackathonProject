package com.hackathon.insurance.utils;

import java.util.Date;

public class DateUtils {
	
//	public String[] convertToXpath(String startDate,String endDate){
//		date = new Date();
//		String[] st = new String[2];
//		st[0] = "//*[@aria-label='Selected as start date. "+ date.toString() +"']"; 
//		return st;
//	}
	
	public static String dateFormatstamp(){
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}
}
