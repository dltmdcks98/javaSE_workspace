
public class OMain2 {
public static void main(String[] args) {
	//게장 객체 
	//게장 이름 가격
	//만든 사람 = "김수미"
	
	//객체 생성 전에 이름이나 관련 내용을 물어보면 대답할 수 없다. 
	//게장 만든 사람은 누구인가? => static으로 설정된 변수의 값은 출력할 수 있다.
	System.out.println(Gejang.producer);
	
	Gejang g = new Gejang();
	g.name="연말특선게장";
	g.price=7000;
	
	
	
	Computer c1 = new Computer();
	c1.cpu = "i7-1234";
	c1.ram = 8;
	c1.hdd = 600;
	c1.print();
	
	Computer c2 = new Computer();
	c2.cpu = "i7-7544";
	c2.ram = 4;
	c2.hdd = 600;
	c2.print();
}
}
