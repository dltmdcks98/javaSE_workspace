package jul19_IsA;

public class OMain3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coffee c = new Coffee();
		c.name="아메리카노";
		c.price=3000;
		c.size="톨";
		c.temp = "따뜻하게";
		c.print();
		System.out.println("================================");
		
		Gimbab g = new Gimbab();
		g.name="김밥";
		g.price=2500;
		g.print();
		
		System.out.println("================================");

		Alchol a = new Alchol();
		a.name="진로";
		a.price=5000;
		a.alchol=20;
		a.print();
	}

}
