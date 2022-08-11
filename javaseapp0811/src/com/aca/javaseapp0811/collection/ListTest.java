package com.aca.javaseapp0811.collection;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ListTest extends JFrame { //ListTest는 윈도우 창이다 라는 뜻
	//벰버볌수는 부품이 오고 부품관계를 has a 관계라 한다.
	//객체를 멤버변수로 선언한 경우를 has a 관계라 한다.
	JButton bt_create,bt_color;
	JPanel p;//비어있는 컴포넌트 div같은거

	//앞으로 생성될 버튼을 담을 배열
//	JButton[] btArray=new JButton[] 유저가 동적으로 버튼을 생성하므로 배열로는 해결할 수 없다.
	List<JButton>btList = new ArrayList<JButton>();
	
	public ListTest() {
		bt_create = new JButton("버튼생성");
		bt_color = new JButton("색상적용");
		p = new JPanel();
		
		p.setBackground(Color.YELLOW);
		p.setPreferredSize(new Dimension(380,450));
		//this는 heap영역에 있는 자기 자신의 변수를 가르킴
		//this는 레퍼런스 변수 객체의 인스턴스가 자기 자신을 가리키는 변수 용도
		this.setLayout(new FlowLayout());
		add(bt_create);
		add(bt_color);
		add(p);
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//대문자의 의미 : public,static,final의 속성을 가지고 있다. 
		
		//이벤트 연결코드는 1회성이므로 .java로 만들 필요가 없다. 따라서 내부익명클래스로 생성한다.
		bt_create.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//동적으로 버튼 생성 
				createBtn();
			}
		});
		
		bt_color.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				setColor();
			}
		});
	}
	public void createBtn() {
		JButton bt = new JButton("버튼1");
		btList.add(bt);
		System.out.println("현재 생성된 버튼의 수"+ btList.size());
		p.add(bt);//패널은 Default값이 FlowLayout
		p.updateUI();//화면 갱신 요청

		
	}
	public void setColor(){
		//동적으로 생성된 모든 버튼의 배경색을 blue색으로 변경 
//		for(int i=0; i<btList.size();i++) {
//			JButton bt = btList.get(i);//<>를 넣으면 제너릭 타입으로 변경되므로 형변환이 필요없다.
//			bt.setBackground(Color.BLUE);
//		}
		//컬렉션 프레임웍을 다룰때 사용한 improved for문 속도가 느림
		for(JButton bt:btList) {
			bt.setBackground(Color.BLUE);
		}
	
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ListTest();
	}

}
