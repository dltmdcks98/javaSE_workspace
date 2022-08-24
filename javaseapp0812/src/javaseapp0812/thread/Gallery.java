package javaseapp0812.thread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Gallery extends JFrame {
	JPanel p_controller;
	JPanel p_content;
	JButton bt_prev,bt_next,bt_auto;
	Image image;//자바에서 이미지를 표현한 객체이고, 이미지 인스턴스를 얻는 방법은 상당히 다양하다
//	URL url;
	
	FileReader reader;// 한문자씩 읽을 수 잇는 스트림
	BufferedReader buffr;//버퍼처ㅣㄹ된 문자 기반 입력 스트림
	
	public Gallery() {
		

		p_controller = new JPanel();
		
		loadImage();
		
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
		
		//다음 버튼에 대한 이벤트 구현 
		bt_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				next();
			}
		});
		
	}
	//프로그램에서 사용할 데이터 가져오기 
	public void init(){
		//json은 파일로 존재하는데 실행중인 자바 프로그램에서 문서 파일을 읽어야 하므로,
		//필요한 기술은 입력스트림이 필요하다.
		
	}
	
	
	//다음 사진 나오게
	public void next(){
		
	}
	public void loadImage() {
		//json 로컬 파일로부터 이미지 정보를 얻어와 image객체생성하기 
		//data.json이 패키지 경로에 있을때 파일을 접근하는 방법
//		URL url = this.getClass().getResource("/javaseapp0812/res/data.json");//일반파일인 경우에는 패키지는 .대신 /로 한다.
		File file = new File("Z:/SLAcademy/javaSE_workspace/javaseapp0812/data/data.json");
		FileReader reader = null;
		
		try {
			reader = new FileReader(file);
			JSONParser jsonParser = new JSONParser();
			//파싱한 결과는 string 문서로 존재하던 json파일을 읽어들여  json 객체화시킨것
			//{}--> JSON.parse()와 동일...(javascript)
			JSONObject jsonObject=(JSONObject) jsonParser.parse(reader); //json을 해석 시도
			JSONArray jsonArray=(JSONArray)jsonObject.get("marvel");//key값으로 데이터 접근
			
			JSONObject movieJson=(JSONObject)jsonArray.get(1);//배열의 0번째 요소 접근
			System.out.println(movieJson.get("url"));
			
			URL url = new URL((String)movieJson.get("url"));
			image = ImageIO.read(url);
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		
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
