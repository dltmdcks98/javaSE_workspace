package Day1;

public class changeType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//두개의 숫자(정수:int)를 사칙연산해서 결과를 출력하시오
				int data1= 7;
				int data2= 2;
				double data3 = data1/data2;
				System.out.println(data1+data2);
				System.out.println(data1-data2);
				System.out.println(data1*data2);
		//1.소숫점을 표시하려면 앞에 형변환을 하면 나온다.
		//2.기본 자료형을 float으로 변환한다.
				System.out.println((float)data1/(float)data2);
	}

}
