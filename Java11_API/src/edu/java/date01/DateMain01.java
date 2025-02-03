package edu.java.date01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateMain01 {

	public static void main(String[] args) {
		// 시스템의 현재 시간 정보
		LocalDate today = LocalDate.now();                                                                                 
		System.out.println("오늘 날짜 : " + today);
		LocalDate specificDate = LocalDate.of(2024, 12, 31);
		System.out.println("특정 날짜 : " + specificDate);
		LocalTime now = LocalTime.now();
		System.out.println("현재 시간 : " + now);
		
		LocalDateTime currTime = LocalDateTime.now();
		System.out.println("현재 날짜와 시간 : " + currTime);
	}

}
