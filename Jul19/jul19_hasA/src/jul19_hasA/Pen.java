package jul19_hasA;

public class Pen {
	String name;
	int price;
	String color;
	public Pen() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Pen(String nmme, int price, String color) {
		super();
		this.name = nmme;
		this.price = price;
		this.color = color;
	}


	public void print() {
		System.out.println(name);
		System.out.println(color);
		System.out.println(price);
	}
	
}
