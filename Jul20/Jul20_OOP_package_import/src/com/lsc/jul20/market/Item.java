package com.lsc.jul20.market;

public class Item {
	String name;
	int price;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
/**
 * 	
 * @param name :상품의 이름을 넣어준다.
 * @param price : 상품의 가격을 입력 
 */
	public Item(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	/**
	 * 출력문 
	 */
	public void print() {
		System.out.println(name);
		System.out.println(price);
	}
}
