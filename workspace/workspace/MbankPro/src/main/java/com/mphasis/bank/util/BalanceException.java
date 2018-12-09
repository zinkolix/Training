/**
 * Balance Exception class to catch the Exception thrown while deposit or withdrawal.
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bank.util;

public class BalanceException extends Exception {

	public BalanceException() {
		super();
	}

	public BalanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BalanceException(String message, Throwable cause) {
		super(message, cause);
	}

	public BalanceException(String message) {
		super(message);
	}

	public BalanceException(Throwable cause) {
		super(cause);
	}

	
}
