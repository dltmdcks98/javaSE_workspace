package Score_Package;

import java.util.Scanner;

public class Student {
		//데이터 구역
			private String  sName; //private이 캡슐화 
			private int sKor, sEng, sMath, sTot;
			private float sAvg;
			
	
			//메소드 구역
			//셋터( 데이터 셋팅
			//겟터(데이터 반환
			//풋터(데이터 출력
//			public void setScore(int k, int e, int m) {
//				sKor = k;sEng=e; sMath =m;
//			} -> 입력으로 바꿀 수 잇게 변경, 에러 처리(데이터가 정삭적인지), 음수가 입력되었다면 에러메시지를 출력하고 중단 
			
			public int setScore() {
				int k =0,e=0,m=0;
				Scanner scn = new Scanner(System.in);
				System.out.print("국어 점수를 입력하세요");
				k = scn.nextInt();
				System.out.print("영어 점수를 입력하세요");
				e = scn.nextInt();
				System.out.print("수학 점수를 입력하세요");
				m = scn.nextInt();
				if((k<0) || (e<0) || (m<0)) {//()를 넣어서 우선순위를 표현 
					System.out.println("음수가 입력되었습니다.");
					return(-1);//메소트 중단하고 빠져나간다.
				}else {
					sKor = k;
					sEng = e;
					sMath = m;
					System.out.println("정상 입력되었습니다.");
					return 0;//return을 하면 모든 경우에서 return이 되어야함  
				}
				
				
			}
			public int getTotScore() {
				//총점을 리턴해준다.
				sTot = sKor+sEng+sMath;
				return sTot;
			}
			public float getAvgScore() {
				sAvg=sTot/3.0f;
				//평균을 리턴
				return sAvg;
			}
			public void putScore() {
				System.out.println("국어 : "+sKor+" 영어 : "+sEng+" 수학 : "+sMath);
				System.out.println("총점 : "+sTot+"평균: "+Math.round(sAvg));
			}
	
}
