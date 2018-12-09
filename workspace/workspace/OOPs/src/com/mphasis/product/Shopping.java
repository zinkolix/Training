package com.mphasis.product;

import java.util.Vector;

public class Shopping {

	//private Product[] cart;
	private int idx;
	private Vector<Product> cart;
	private double total;
	private int[] quantity; 
	
	public Shopping() {
		cart = new Vector<Product>(5);
		quantity = new int[5];
		idx = -1;
	}
	
	public void addProduct(Product item, int qty) {
		if(idx < cart.size()) {
			
			if(item.getStock() > qty ) {
				quantity[++idx] = qty;
//				cart[idx ++] = item;
				cart.add(item);
				total += (item.getPrice() * qty);
				item.setStock(qty);
			}
			else
				System.out.println("out of stock");
		}else
			System.out.println("Your cart is full");
	}
	
	public void summary() {
		System.out.println("Products in cart");
//		for( int i = 0; i < idx; i++) {
//			double sub =  quantity[i] * cart[i].getPrice();
//			System.out.println("Product Name: " + cart[i].getName() + "\t Quantity: " + quantity[i] + " X " + cart[i].getPrice() + " = " + sub);
			int i = 0;
			for (Product p : cart) {
				double sub =  quantity[i] * p.getPrice();
				System.out.println("Product Name: " + p.getName() + "\t Quantity: " + quantity[i] + " X " + p.getPrice() + " = " + sub);
				i++;
			}
			System.out.println("-------------------------------");
			System.out.println("Cart Total: "  + total);
		}
		
	
	
	public void payment(String cardNo, String exp, int cvv){
		//exp = "20/12/2019";
		int cur = 2018;
		int month;
		int year;
		String[] ar = exp.split("/");
		//date = Integer.parseInt(exp.substring(0, 2));
		month = Integer.parseInt(ar[0]);
		year = Integer.parseInt(ar[1]);
		
		if(cardNo.length() == 16 && cvv >= 100 && cvv <=999 && year - cur <= 3 && month <= 12 && month >=1){
				System.out.println("Transaction Successful");
		}else
				System.out.println("Transaction failed");
		
	}
}
