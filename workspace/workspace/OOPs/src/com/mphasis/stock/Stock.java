package com.mphasis.stock;

public class Stock implements Exchange {

	@Override
	public void getQuote() {
		System.out.println("This is getQuote method.");

	}

	@Override
	public void viewQuote() {
		System.out.println("This is viewQuote method.");

	}

	@Override
	public void setQuote() {
		System.out.println("This is setQuote method.");

	}

}
