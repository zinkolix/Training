package com.mphasis.bankweb.util;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mphasis.bankweb.dao.util.CheckExistingIdDao;

@Service("util")
public class BankUtil {
	@Autowired
	@Qualifier("checkId")
	CheckExistingIdDao dao;
	
	private int genFiveDigitRandom() {

		int num = (int) (Math.random() * 99999);
		if (num >= 10000 && num <= 99999) {
			return num;
		} else {
			return genFiveDigitRandom();
			
		}
	}

	public String genEmpNo() {
		String empId = String.valueOf(genFiveDigitRandom());
		if (dao.checkExistingEmpId(empId) == true)
			return empId;
		else
			return genEmpNo();
	}

	public String genCustomerNo() {
		String str = "MLA" + genFiveDigitRandom();
		if (dao.checkExistingCustId(str) == true)
			return str;
		else
			return genCustomerNo();
	}

	public String getSBAccountNo() {
		String str = "SB" + genFiveDigitRandom();
		if (dao.checkExistingDepositAccntId(str) == true)
			return str;
		else
			return getSBAccountNo();
	}

	public String genLNAccountNo() {
		String str = "LN" + genFiveDigitRandom();
		if (dao.checkExistingLoanAccntId(str) == true)
			return str;
		else
			return genLNAccountNo();
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
	
}
