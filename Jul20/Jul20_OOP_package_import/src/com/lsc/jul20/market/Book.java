package com.lsc.jul20.market;

public class Book extends Item {
	String Author;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String name, int price, String author) {
		this.name = name;
		this.price = price;
		Author = author;
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println(Author);
	}
}
