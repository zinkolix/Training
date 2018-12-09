package com.mphasis.currency;

public class CurrencyConverter {
	

	public double convert(Currency source, Currency target, double amount){
		 
		double price  = target.dollarValue() / source.dollarValue() * amount;
		return price;
	}
	
}
