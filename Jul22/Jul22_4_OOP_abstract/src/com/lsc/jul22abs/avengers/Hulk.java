package com.lsc.jul22abs.avengers;

public class Hulk extends Avengers {
	private int size;
	
	public Hulk() {
		// TODO Auto-generated constructor stub
	}

	public Hulk(String name, int age, String type, int size) {
		super(name, age, type);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("주먹질");
	}
	
	
	
}
