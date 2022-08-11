package com.aca.javaseapp0811.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
	
		map.put("a", "apple");
		map.put("b", "banana");
		map.put("c", "cocoa");
		map.put("m", "mango");
		map.put("p", "pineapple");
		
		System.out.println("총 과일의 수 : " + map.size());
		
		Set<String> set = map.keySet();
		Iterator<String> it =  set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			//얻어진 키를 이용하여 맵 안에서 추출
			System.out.println(map.get(key)); 
		}
	}

}
