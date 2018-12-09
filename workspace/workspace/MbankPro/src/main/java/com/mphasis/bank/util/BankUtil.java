/**
 * BankUtil class generates the ID respective to account.
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bank.util;

import org.hibernate.type.descriptor.java.UUIDTypeDescriptor.ToStringTransformer;

public class BankUtil {

	private static int getFiveDigitRandom() {
		int random = (int) (Math.random() * 99999);
//		while((random >= 10000 && random <= 99999) != true)
//			getFiveDigitRandom();			
		return random;
	}

	public static int generateEmployeeId() {
		return getFiveDigitRandom();
	}

	public static String generteCustomerId() {
		return "MLA" + getFiveDigitRandom();
	}

	public static String generateSBAccountId() {
		return "SB" + getFiveDigitRandom();
	}

	public static String generateLNId() {
		return "LN" + getFiveDigitRandom();
	}
	
	public static double calculateEMI(){
		return 0;
		
	}

}
