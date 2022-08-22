package jul19_hasA;


//홍길동이라는 사람이 펜ㄷ을 가지고있는 상태면
public class OMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pen p =new Pen("모나미",1000,"검정색");
		p.print();
		
		Student s = new Student("홍길동",20);
		s.print();
		
		Student s1 = new Student("홍길동",20,p);
		
		Dog d = new Dog("뽀삐", 3, s1);
		
		//d의 주인이 가지고 있는 펜의 색
		System.out.println(d.owner.pen.color);
		
	}

}
