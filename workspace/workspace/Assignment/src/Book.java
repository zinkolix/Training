//package com.mphasis.lib;

import java.util.Vector;

public class Book {
	private int isbn;
	private String title;
	private String author;
	private double price;
	private int idx;
	//private Member[] members;
	private Vector<Member> members;
	public Book() {
		
	}

	public Book(int isbn, String title, String author, double price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		//members = new Member[3];
		members = new Vector<Member>(3);
	}
//	
	

	public void summary() {
		System.out.println("ISBN: " + isbn);
		System.out.println("Title: "+ title);
		System.out.println("Author: " + author);
		System.out.println("Price: " + price);
				
	}

	public String getTitle() {
		return title;
	}

	public void issueBook(Member mbr){
		if(mbr.getBook() == null){
			if(idx < members.size()){
				members.add(mbr);
				mbr.setBook(this);
				
			}else {
				System.out.println(title + "is out of stock");
			}
		}else {
				System.out.println(mbr.getmName() + " already issued a book");
			}
		}
	
	
	public void status() {
		if(idx == 0){
			System.out.println(title + "is not issued to any member yet");
		} else { 
			System.out.println("List of members to whom " + title + "issued");
//			for(int i = 0; i < idx; i++ ){
//				System.out.println(members.getmName());
			for (Member m : members) {
				m.getmName();
			}
			}
		}
	}

