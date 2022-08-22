package Day1;
import java.util.Scanner;

public class ForandIf {

	public static void main(String[] args) {
		/*pw를 3번까지 물어보고 그 이상 틀리면 더이상  로그인을 할 수 없음 
		애략의 코드 골격은 아래와 같은 
		비밀번호 입력받음
		반복문으로 3번 반복시킴
		반복문안에 if문을 사용해서 비밀번호를 물어봄
		만약 일치하지 않으면 지금 까지 3회가 넘지 않았는지 판단한 후 
		3회 내라면 다시 물어 볼수 있게 해줌
		3회이상라면 더이상 비밀번호를 입력할 수 없게함 
		*/
		//내가 시도한 방법
//		Scanner scn = new Scanner(System.in);
//		String id = "admin"; 
//		String pw = scn.nextLine();
//		for(int i =1; i<4; i++) {
//			if(pw.equals("123##")) {
//				System.out.println("로그인 성공");
//				break;
//			}else {
//				if(i==3) {
//					System.out.println("로그인 실패");
//					break;
//				}else {
//				System.out.println("다시 입력 바람");
//				pw = scn.nextLine();
//				}	
//			}	
//		}
		
		//강사님이 틀을 잡고 난 방법 방법은 상관 없
		String userPW;
		Scanner input = new Scanner(System.in);
		for(int i=1; i<=3; i++) {
			userPW = input.nextLine();
			if(userPW.equals("123##")) {System.out.println("로그인했음"); break;}
			else {
				if(i<3) continue;
		}
			}
		
	}
}