package com.lsc.jul22abs.avengers;

import com.lsc.jul22abs.smoker.Smoker;

public class IronMan extends Avengers implements Smoker {
	private String computer;
	
	public IronMan() {
		// TODO Auto-generated constructor stub
	}
	
	public IronMan(String name, int age, String type, String computer) {
		super(name, age, type);
		this.computer = computer;
	}


	@Override
	public void attack() {
		System.out.println("빔");
	}

	public String getComputer() {
		return computer;
	}

	public void setComputer(String computer) {
		this.computer = computer;
	}


	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println(computer);
	}

	@Override
	public void d() {
		// TODO Auto-generated method stub
		
	}
	
	
}
