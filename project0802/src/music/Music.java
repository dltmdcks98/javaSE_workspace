package music;
/*
박종호 사원이 원하는 mp3플레이어
자식객체로 하여금, 구현을 강제하기 위한 클래스가 바로 추상클래스인데, 
추상클래스는 클래스이므로, 다중상속 금지의 원칙에 의해 여러 객체들을 부모로 둘 수 없다
인터페이스는 상수와 추상메소드 즉 기능만을 가지고 있는 집합 */
public class Music extends MusicPlayer implements JetEngine
{
	int price;
	String color;
	public void play(){
		
	}
	public void readMP3(){
		System.out.println("재생");
	}
	public void setVolume(){
		System.out.println("");
	}

	public void fly(){
		
	}
}
