/*
java언어도  c#과 같은 일반적인 응용프로그램처럼 GUI를 지원 
*/
package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.CheckboxGroup;
import java.awt.TextArea;
public class  ChatMain
{
	public static void main(String[] args) 
	{
		//윈도우 생성
		Frame frame = new Frame();
		frame.setVisible(true);
		frame.setSize(300,400);

		//버튼 생성
		Button bt = new Button("나 버튼");

		//텍스트 입력
		TextField t = new TextField(10);//10자 정도의 크기

		Checkbox ch = new Checkbox("게임");
		Checkbox ch1 = new Checkbox("프로그래밍");


		Choice c = new Choice();
		c.add("red");
		c.add("yellow");
		c.add("blue");

		//Radio 별도로 지원하지 않고 CheckBox를 그룹화
		CheckboxGroup cbg = new CheckboxGroup();
		Checkbox c1 = new Checkbox("남",cbg,true); 
		Checkbox c2 = new Checkbox("여",cbg,false);
		Checkbox c3 = new Checkbox("트랜스",cbg,false);
 

 		//TextArea(멀티란인 입력창)
		TextArea area = new TextArea(20,10);//row,col
		//프레임에 적용할 배치관리자 
		frame.setLayout(new java.awt.FlowLayout());

		frame.add(bt);
		frame.add(t);
		frame.add(ch);
		frame.add(ch1);
		frame.add(c);
		frame.add(c1);
		frame.add(c2);
		frame.add(c3);
		frame.add(area);

	}
}
