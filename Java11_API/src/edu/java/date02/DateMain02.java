package edu.java.date02;

import java.time.LocalDateTime;

public class DateMain02 {
	
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		
		System.out.println("년 : " + year);
		System.out.println("월 : " + month);
		System.out.println("일 : " + day);
		System.out.println("시 : " + hour);
		System.out.println("분 : " + minute);
		System.out.println("초 : " + second);
	}
}
