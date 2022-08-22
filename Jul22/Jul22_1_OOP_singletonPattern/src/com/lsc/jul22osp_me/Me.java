package com.lsc.jul22osp_me;

public class Me {
	private String name;
	private String liveIn;
	private int age;
	
	//2.객체를 외부에서 만들지 못하게, 수정 불가능 하게 
	private static final Me M = new Me("이승찬", "당동", 25);
	private Me() {
		// TODO Auto-generated constructor stub
	}
	public static Me getMe() {
		return M;
	}
	
	//1.객체를 외부에서 못 만들게 생성자를 private로 생성
	private Me(String name, String liveIn, int age) {
		super();
		this.name = name;
		this.liveIn = liveIn;
		this.age = age;
	}

	
	//외부에서 조작하기 위한 메소드들 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLiveIn() {
		return liveIn;
	}

	public void setLiveIn(String liveIn) {
		this.liveIn = liveIn;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Me [name=" + name + ", liveIn=" + liveIn + ", age=" + age + "]";
	}
	
	
}
