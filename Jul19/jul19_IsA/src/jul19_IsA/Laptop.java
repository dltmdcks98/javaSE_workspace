package jul19_IsA;

public class Laptop extends Computer{
	int weight;
	int battery;
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println(weight);
		System.out.println(battery);
	}

}
