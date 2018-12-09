/**
 * 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bank.util;

public class BankUtil {

	private static int getFiveDigitRandom() {
		int random = (int) (Math.random() * 99999);
		if (random <= 99999 && random > 99999) {
			return random;
		} else {
			getFiveDigitRandom();
			return 0;
		}

	}

	public String generteCustomerId() {
		return "MLA" + getFiveDigitRandom();
	}
}
