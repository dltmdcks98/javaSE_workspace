package jul19_IsA;

public class OMain2 {
public static void main(String[] args) {
	Computer c = new Computer();
	c.name = "매직스테이션123";
	c.price =80;
	c.cpu="i7-1234";
	c.ram = 16;
	c.hdd = 500;
	c.print();
	System.out.println("================================");
	Laptop l = new Laptop();
	l.name="그램123";
	l.price=200;
	l.cpu="i7-211";
	l.ram=16;
	l.hdd=100;
	l.weight=3;
	l.battery=2;
	l.print();
}
}
