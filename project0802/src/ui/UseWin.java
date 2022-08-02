package ui;
//현실의 객체를 표현하고자 함이 아닌 그냥 실행할 하기 위한 클래스 => 실행부가 있어야함

class UseWin 
{
	WinTest winTest;//인스턴스 변수임으로 같은 멤버만이 접근할 수 있다. 
	
	public UseWin(){
		winTest = new WinTest();
	}
	public static void main(String[] args) 
	{
		new UseWin();
	}
}
