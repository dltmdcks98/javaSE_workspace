package com.aca.day0801.main;
public class Arrow
{
	int y;
	String str;
	int velX;
	public Arrow(int y, String str, int velX){
		this.y=y;
		this.str = str;
		this.velX = velX;
	}

	public void move(){
		this.x += this.velX;
	}
	public static void main(){
		Arrow a1 = new Arrow(105,"¡Ù",10);
		a1.move();
	}
}
