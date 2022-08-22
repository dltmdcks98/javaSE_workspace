package com.lsc.jul22osp_main;

import com.lsc.jul22osp_device.Phone;
import com.lsc.jul22osp_me.Me;

public class OMain {
	public static void main(String[] args) {
		Me m = Me.getMe();
		Me m1 = Me.getMe();
		Me m2 = Me.getMe();
		
		
		//모든 객체의 주소가 같다
		System.out.println(m);
		System.out.println(m1);
		System.out.println(m2);
		
		System.out.println("================================");
		Phone p = Phone.getPhone();
		Phone p1 = Phone.getPhone();
		Phone p2 = Phone.getPhone();
		
		System.out.println(p);
		System.out.println(p1);
		System.out.println(p2);
		p.setModel("123");
		System.out.println(p);
		System.out.println(p.getModel());
	}
}
