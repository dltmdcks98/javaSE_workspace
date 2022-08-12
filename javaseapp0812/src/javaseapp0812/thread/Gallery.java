package javaseapp0812.thread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gallery extends JFrame {
	JPanel p_controller;
	JPanel p_content;
	JButton bt_prev,bt_next,bt_auto;
	Image image;//자바에서 이미지를 표현한 객체이고, 이미지 인스턴스를 얻는 방법은 상당히 다양하다
	URL url;
	public Gallery() {
		

		p_controller = new JPanel();
		p_content = new JPanel(){//내부익명클래스
			/*개발자가 컴포넌트를 그냥 사용하면  sun에서 정해놓은 그림을 이욯하게 되는데
			 * 개발자가 커스터마이징도 할 수 있는데 이때 오버라이드 해야할 메서드가 
			 * paint()이다.*/
			
			//아래의 메서드를 재정의하는 순간부터는 개발자가 그린 그림을 우선시해준다.
			//paint() 호출시점은 다시 그려져야 할때 
			public void paint(Graphics g) {
				System.out.println("내그림");
			
				g.drawImage(image, 0, 0, 600, 500, p_controller);
			}
		};
		bt_prev = new JButton("이전");
		bt_next = new JButton("다음");
		bt_auto = new JButton("auto");
		
		//스타일
		p_controller.setPreferredSize(new Dimension(600,50));
		p_controller.setBackground(Color.CYAN);
		p_content.setPreferredSize(new Dimension(600,500));
		p_content.setBackground(Color.YELLOW);
		
		setLayout(new FlowLayout());
		
		p_controller.add(bt_prev);
		p_controller.add(bt_next);
		p_controller.add(bt_auto);
		
		add(p_controller);
		add(p_content);
		
		
		//윈도우 속성
		setLocationRelativeTo(null);//화면 가운데로 윈도우가 하나라 중앙에 위치
		setSize(600,550);
		setVisible(true); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		loadImage();
	}
	public void loadImage() {
		//json 로컬 파일로부터 이미지 정보를 얻어와 image객체생성하기 
		//data.json이 패키지 경로에 있을때 파일을 접근하는 방법
		URL url = this.getClass().getResource("/javaseapp0812/res/data.json");//일반파일인 경우에는 패키지는 .대신 /로 한다.
		System.out.println(url);
//		
//		try {
//			url= new URL("https://images-na.ssl-images-amazon.com/images/I/91qvAndeVYL._RI_.jpg");
//			image=ImageIO.read(url);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public static void main(String[] args) {
		new Gallery();
	}
	
}
