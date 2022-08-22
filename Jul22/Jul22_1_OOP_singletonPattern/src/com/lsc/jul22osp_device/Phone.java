 package com.lsc.jul22osp_device;

public class Phone {
	private String model;
	private int number;
	
	//밖에서 못 건듦
	private static final Phone P = new Phone("iPhone12Pro",010123123);
	
	private Phone() {
		// TODO Auto-generated constructor stub
	}
	
	public static Phone getPhone() {
		return P;
	}
	
	private Phone(String model, int number) {
		super();
		this.model = model;
		this.number = number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public static Phone getP() {
		return P;
	}
	
	
	

}
