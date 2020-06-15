package com.course.practicaljava.rest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Random;

public class RandomDateUtil {
	
	private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	private static String generateRandomDate() {
		Random random = new Random();
		int day = random.nextInt(31);
		int month = random.nextInt(13);
		int actDay = (day == 0)?1:day;
		int actMonth = (month == 0)?1:month;
		int year = 2000 + random.nextInt(101);
		
		return day +"/" + month + "/" + year;
	}
	
	
	public static Date parseDate() throws ParseException {
		return formatter.parse(generateRandomDate());
	}

}
