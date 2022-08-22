package com.lsc.jul25ej.main;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String a= new String("오늘날시참좋네");
			
			//5번째 글자
			System.out.println(a.charAt(4));
			
			//"오늘"로 시작하는지?
			System.out.println(a.equals("오늘%"));
			System.out.println(a.startsWith("오늘"));
			//2~5번째 글자
			System.out.println(a.substring(1, 4));
			//총 몇 글자 인지
			System.out.println(a.length());
			//오늘-> 내일 
			System.out.println(a.replace("오늘", "내일"));
			
			System.out.println(a);
			//바꾸고 다시 a를 출력하면 다시 "오늘"로 나온다. String은 값을 변경할 수 없다. 
			
			
			//a에 ㅋㅋㅋㅋ추가
			a+="ㅋㅋㅋㅋㅋㅋ";
//			=> a= a+ new String("ㅋㅋㅋㅋㅋ");로 쓰는데 이는 객체를 계속 생성하는 것 이라 ram에 무리가 감
			
			//글자를 대량으로 붙여야 한다면
			StringBuffer sb = new StringBuffer();
			sb.append("ㅋㅋㅋㅋ");
			
			
			System.out.printf("%02d\r\n",3);
			String ss = String.format("%02d", 8);
			System.out.println(ss);
//			로 해야 ram에 무리가 덜 간다. 
			
			
			//글자를 분리해야할때
			String s3= "홍길동/20/학생";//정형 데이터 = 데이터의 형식이 정해져 있는 것
			String[] s33= s3.split("/");
			System.out.println(s33[2]);
			
			
			String s4 = "오늘 날씨가 참 좋네요, 아주 기분이 좋습니다.";
			StringTokenizer st = new StringTokenizer(s4," ");//띄어쓰기 기준으로 나눔
			System.out.println(st.nextToken());
			System.out.println(st.nextToken());
			
			//알아서 잘게 쪼게서 출력 
			while(st.hasMoreTokens()) {
				System.out.println(st.nextToken());
			}
		
	}

}
