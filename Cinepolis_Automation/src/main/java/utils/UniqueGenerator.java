package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

import com.github.javafaker.Faker;

public class UniqueGenerator {

	public static int getRandomNumber(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

	public static String calculateYear(int monthsToSubtract) {
		// Get the current year and month
		YearMonth currentYearMonth = YearMonth.now();

		// Subtract the specified number of months
		YearMonth resultYearMonth = currentYearMonth.minusMonths(monthsToSubtract);

		// Return the year of the result as a string
		return String.valueOf(resultYearMonth.getYear());
	}

	public static String getCurrentDateTime() {

		String dateTime = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(Calendar.getInstance().getTime());
		return dateTime.replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "");
	}

	public static String getcurrentDate() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM");
		String formattedDate=currentDate.format(formatter);
		return formattedDate.toUpperCase();
	}

	public static String getuniqueemail() {
		return "rahul" + getCurrentDateTime() + "@yopmail.com";
	}

	public static String setUniquename() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}

	public static String setUniquelastname() {
		Faker faker = new Faker();
		return faker.name().lastName();
	}

	public static String setPhoneNo() {
		Faker faker = new Faker();
		int firstDigit = faker.number().numberBetween(6, 10);
		long remainingDigits = faker.number().numberBetween(100000000L, 999999999L);
		return firstDigit + String.valueOf(remainingDigits);
	}
}
