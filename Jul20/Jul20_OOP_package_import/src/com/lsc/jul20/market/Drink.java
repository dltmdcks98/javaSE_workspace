package com.lsc.jul20.market;

public class Drink extends Item{
	String life;
	
	public Drink() {
		// TODO Auto-generated constructor stub
	}
/**
 * 
 * @param name
 * @param price
 * @param life
 */
	public Drink(String name, int price, String life) {
		super(name, price);
		this.life = life;
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println(life);
	}
}
