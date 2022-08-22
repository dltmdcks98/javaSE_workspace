package com.lsc.oopecl.main;

import com.lsc.oopecl.computer.Computer;

public class OMain2 {
	public static void main(String[] args) {
		Computer c = new Computer("i71234",16,500);
		System.out.println(c.toString());
		
		c.setHdd(900);
		System.out.println(c.toString());
	}
}
