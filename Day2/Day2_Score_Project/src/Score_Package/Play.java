package Score_Package;
public class Play {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Student s = new Student(); // 객체 생성
		int err = s.setScore();
		//에러처리를 한다면 -1이냐 0이냐에 따라 에러처리를 할 것이다.
			s.setScore();
			s.getTotScore();
			s.getAvgScore();
			s.putScore();
		
	}

}
