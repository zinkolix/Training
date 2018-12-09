//package com.mphasis.lib;

public class Member {

	
	private String mName;
	private Book book;
	public Member() {
	
	}
	
	
	
	public Member(String mName) {
		this.mName = mName;
	}



	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}



	public String getmName() {
		return mName;
	}
	
	public void status() {
		if(book != null){
			System.out.println(mName + " has issued " + book.getTitle());
		}else {
			System.out.println("No book issued by " + mName);
		}
	}



		

}
