package com.aca.javaseapp0811.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>(); //Generic타입
	
		set.add("파인애플");
		set.add("오렌지");
		set.add("키위");
		set.add("망고");
		set.add("바나나");
		
		System.out.println("담겨진 과일의 수는 "+set.size());
		
		//담겨진 과일 출력, 순서 없는 집합이므로 별도의 도구를 이용하는데 
		//이때 도구는 일렬로 늘어뜨리는 기능을 Enumeration,Iterator가 있다.
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String name = it.next();
			System.out.println(name);
			
		}
	}

}
