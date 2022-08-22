package com.lsc.jul22abs.main;

import com.lsc.jul22abs.avengers.Avengers;
import com.lsc.jul22abs.avengers.Hulk;
import com.lsc.jul22abs.avengers.IronMan;
import com.lsc.jul22abs.human.Human;

public class OMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IronMan i = new IronMan("토니",40,"아이언맨","자비스");
		i.print();
		i.attack();
		
		
		Hulk h = new Hulk("베너", 35, "헐크", 40);
		h.attack();
		h.print();
		
		//객체를 만들면서 일회용으로 클래스를 생성 
		Avengers a = new Avengers() {
			//클래스인 부분 => 익명 클래스 new Avengers() 부분의 Avengers()는 상위 객체 "{" 익명 클래스 
			@Override
			public void attack() {
				// TODO Auto-generated method stub
				System.out.println("공격");
			}
		};
		a.attack();
	}

	
		Human h = new Human("홍길동", 30);
		System.out.println(h.toString());
}