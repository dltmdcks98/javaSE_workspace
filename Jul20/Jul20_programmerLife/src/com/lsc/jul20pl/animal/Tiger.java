package com.lsc.jul20pl.animal;
/**
 * 
 * @author lsc
 *
 */
public class Tiger extends Animal {
	int age;
	
	public Tiger() {
		// TODO Auto-generated constructor stub
	}

	public Tiger(int age) {
		super();
		this.age = age;
	}
	
	/**
	 * 
	 * @param a weight
	 * @param b length
	 * @param c bmi
	 * @return print.
	 */
	public int add(int a, int b, int c) {
		return a+b+c;
	}
}
