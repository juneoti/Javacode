package edu.java.date03;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class DateMain03 {

	public static void main(String[] args) {
		LocalDate startDate = LocalDate.of(2024, 10, 16);
		LocalDate endDate = LocalDate.of(2025, 4, 14);
		Period period = Period.between(startDate, endDate);
		System.out.println(period);
		System.out.println("기간 : " + period.getYears() + "년");
		System.out.println(period.getMonths() + "개월");
		System.out.println(period.getDays() + "일");
		
		LocalTime startTime = LocalTime.of(9, 0);
		LocalTime endTime = LocalTime.of(18, 0);
		Duration duration = Duration.between(startTime, endTime);
		System.out.println("시간 차이 : ");
		System.out.println(duration.toHours() + "시간");
		System.out.println(duration.toMinutes() + "분");
		System.out.println(duration.toSeconds() + "초");

	}

}
