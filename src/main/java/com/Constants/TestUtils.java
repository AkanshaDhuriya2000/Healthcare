package com.Constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestUtils {
	public static void main(String[]args) {
		LocalDateTime datetime=LocalDateTime.now();
		DateTimeFormatter format=DateTimeFormatter.ofPattern("DD-MM-YY");
		String currentdatetime=datetime.format(format);
		System.err.println(datetime.toString());
		System.err.println(currentdatetime);
		
		DateTimeUtils.calculateAge("2022-10-10");
	}

}
