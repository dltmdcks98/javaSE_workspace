package jul19_IsA;

import java.util.Random;

public class holsu extends Random {
	public holsu() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int nextInt(int num) {
		int temp = super.nextInt(num);
		return (temp%2==1)? temp : nextInt(num);
	}
}
