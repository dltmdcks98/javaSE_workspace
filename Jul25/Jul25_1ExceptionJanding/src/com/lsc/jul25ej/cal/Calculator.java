package com.lsc.jul25ej.cal;

public class Calculator {
	public static int div(int a, int b) {
		try {
			return a/b;	
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("나누기 0은 없");
			return 0;
		}finally {
			System.out.println("수고하셨씁니다.");	
		}
	}
	
	public static int div1(int a, int b) throws ArithmeticException  {
			return a/b;	
		
	}
}
