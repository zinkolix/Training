package com.mphasis.bankweb.util;

import java.time.LocalDate;
import java.time.Period;

public class LoanAccountCheck {

	public static double roiChecking(double principle, String date) {
		int age = getAgeChecking(date);
		if (principle < 100000 && age > 65)
			return 9.5;
		else if (principle <= 500000 && principle > 10000 && age < 65)
			return 10;
		else if (principle > 500000 && principle <= 1000000 && age < 65)
			return 9.5;
		else if (principle > 1000000 && age < 65)
			return 9;
		else
			return 0;
	}

	public static int getAgeChecking(String birthdate) {
		String[] dob = birthdate.split("-");
		int yr = Integer.parseInt(dob[0]);
		int mon = Integer.parseInt(dob[1]);
		int dt = Integer.parseInt(dob[2]);
		LocalDate birth = LocalDate.of(yr, mon, dt);
		LocalDate today = LocalDate.now();

		Period period = Period.between(birth, today);
		return period.getYears();
	}

	public static double Outstandingcalc(double principle, double roi, double tenure) {
		double si = (principle * roi * tenure) / 100;
		return principle + si;
	}

	public static double Emicalculate(double principle, double roi, double tenure) {
		return ((Outstandingcalc(principle, roi, tenure)) / (tenure * 12));
	}

	public static boolean checkEmieligible(double emi, double salary) {
		double percentsal = (salary * 60) / 100;
		if (emi < percentsal)
			return true;
		else
			return false;
	}
}
