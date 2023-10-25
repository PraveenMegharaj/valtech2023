package day5;

import java.time.LocalDate;
import java.util.Date;

public class DateSample {

	public static void main(String[] args) {
		Date date = new Date(47, 7, 15);
		System.out.println(date);
		LocalDate indDay = LocalDate.of(1947, 8, 15);
		System.out.println(indDay);

	}

}
