package com.lsc.jul25ej.main;

/*
 * Wrapper class
 * 	기본형(int, double, boolean)의 객체형으로 바꾸는것
 * Integer, Double, Boolean => 앞자리가 대문자로 변경  
 */
public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =10; //=>스택에 값을 저장 
		//객체로 만드는 이유 => 메소드 쓸라고
		Integer aa= new Integer(100); //stack에 주소를 저장 
		

		//기본형 => wrapper형 
		double b = 1.5;
		Double bb= new Double(b);
		
		//wrapper형 => 기본형
		double bbb = bb.doubleValue();
		
		
		boolean c = true;
		Boolean cc= new Boolean(c); //글자에 줄이 그어져 있는 거는 필요없다고 나오는 거
		Boolean c1 = c; //=>기본형->wrapper를 자동으로 해줌(autoboxing)
		
		boolean ccc = cc.booleanValue();
		boolean ccc1 = cc; //wrapper형 -> 기본형으로 자동으로(autounboxing)
	
		int d= 20;
		double z = 7.5;
		//기본형 -> String 
		String dd = d+"";
		String ddd = String.format("%d", d);
		
		String f = "123";
//		Integer f2 = Integer.parseInt(f);
//		int f3 = f2.intValue(); 아래와 같음 
		int f3 = Integer.parseInt(f);
		System.out.println(f3);
		
	}
}
