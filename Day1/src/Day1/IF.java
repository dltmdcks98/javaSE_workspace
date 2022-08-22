package Day1;

import java.util.Scanner;

public class IF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean money = true;
		if (money) {
		    System.out.println("택시를 타고 가라");
		}else {
		    System.out.println("걸어가라");
		}
		
		
		//아이디를 입력받아서 저장함(String )
		//암호를 입력받아서 저장함 
		//입력받은 아이디가 admin이면 관리자 라고 출력
		//입력받은 암호가 123##이면 ok출력
		//위의 2가지 조건이 맞는다면, 로그인되었습니다. 출력
		
		Scanner scn = new Scanner(System.in);
		String id = ""; //레퍼런스 객체, 주소로 검색 
		String pw = "";
		id = scn.next();
		if(id.equals("admin")) {
			System.out.println("관리자\n");
			pw = scn.next();
			if(pw.equals("123##")) {
				System.out.println("ok\n");
				System.out.println("로그인 되었습니다.");
			}else System.out.println("암호가 다릅니다.");
		}else System.out.println("아이디가 다릅니다.");
		
		if(id.equals("admin") && pw.equals("123##")){
				System.out.println("로그인 되었습니다.");}else{System.out.println("다시 로그인하세요");}

	}

}
