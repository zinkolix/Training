package com.mphasis.product;

public class Product {
	private int code;
	private String name;
	private double price;
	private int stock;
	
	public Product() {
		
	}
	
	public double getPrice() {
		return price;
	}

	public void setStock(int stock) {
		this.stock -= stock;
	}

	public int getStock() {
		return stock;
	}
	

	public String getName() {
		return name;
	}

	public Product(int code, String name, double price, int stock) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	public void description(){
		System.out.println("Code: " + code);
		System.out.println("Name: " + name);
		System.out.println("Price: " + price);
		System.out.println("Stock: " + stock);
	}

	
}
