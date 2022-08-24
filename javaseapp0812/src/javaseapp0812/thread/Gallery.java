package javaseapp0812.thread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javaseapp0812.domain.Movie;

public class Gallery extends JFrame {
	JPanel p_controller;
	JPanel p_content;
	JButton bt_prev,bt_next,bt_auto;
	Image image;//자바에서 이미지를 표현한 객체이고, 이미지 인스턴스를 얻는 방법은 상당히 다양하다
//	URL url;
	
	FileReader reader;// 한문자씩 읽을 수 잇는 스트림
	//BufferedReader buffr;//버퍼처리된 문자 기반 입력 스트림
	List<Movie> movieList;
	BufferedImage img;//패널이 그리게 될 이미지 객체
	int index=0;
	public Gallery() {
		

		p_controller = new JPanel();
		
		init();
		System.out.println("최종적으로 모여진 영화의 수"+movieList.size());
		
		loadImage(index);
		
		p_content = new JPanel(){//내부익명클래스
			/*개발자가 컴포넌트를 그냥 사용하면  sun에서 정해놓은 그림을 이욯하게 되는데
			 * 개발자가 커스터마이징도 할 수 있는데 이때 오버라이드 해야할 메서드가 
			 * paint()이다.*/
			
			//아래의 메서드를 재정의하는 순간부터는 개발자가 그린 그림을 우선시해준다.
			//paint() 호출시점은 다시 그려져야 할때 
			public void paint(Graphics g) {
				System.out.println("내그림");
				
				g.drawImage(img, 0, 0, 600, 500, p_controller);
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
		bt_auto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 무한 루프가 걸리게 되므로, 메인스레드는 루프에 넣으면 안됨
				//메인 쓰레드 대신 업무를 처리한 쓰레드로 처리
				Thread thread = new Thread() {
					@Override
					public void run() {
						auto();						
					}
				};
				thread.start();
			}
		});
		
	}
	//프로그램에서 사용할 데이터 가져오기 
	public void init(){
		//json은 파일로 존재하는데 실행중인 자바 프로그램에서 문서 파일을 읽어야 하므로,
		//필요한 기술은 입력스트림이 필요하다.
		try {
			reader = new FileReader("Z:/SLAcademy/javaSE_workspace/javaseapp0812/data/data.json");
			
			//JSON 형식을 이해하고 해석할 수 있는 파서를 이용하여 data.json안에 표기된 데이터를 접근한다.
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);//해석 수행
			
			JSONArray jsonArray=(JSONArray)jsonObject.get("marvel");
			
			//곧 닫히게될 스트림 및 죽게될 jsonArray를 대체하기 위해 
			movieList = new ArrayList<Movie>();
			for(int i=0;i<jsonArray.size();i++) {
				JSONObject obj =(JSONObject) jsonArray.get(i);//영화 한편 추출
				
				Movie movie = new Movie();//영화가 20개면 20개가 만들어 져야해서 반복문 안에 작성
				movie.setUrl((String)obj.get("url"));
				movie.setTitle((String)obj.get("title"));
				
				//list에 담기
				movieList.add(movie);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	//다음 사진 나오게
	public void next(){
		if(index<movieList.size()-1) {
			index++;
			loadImage(index);
			//Panel의 그림을 프로그래밍적으로 다시 그리는 방법
			//repaint() -> update() 화면을 모두 지우고 paint()생성
			p_content.repaint();
		}else {
			JOptionPane.showMessageDialog(this, "마지막 이미지 입니다.");
		}
	}
	public void auto() {

		while(true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			next();
		}
	}
	
	//이 메서드를 호출하는 자는, 원하는 인덱스를 인수로 넘기면 된다.
	public void loadImage(int index) {
		//json 로컬 파일로부터 이미지 정보를 얻어와 image객체생성하기 
		//data.json이 패키지 경로에 있을때 파일을 접근하는 방법
//		URL url = this.getClass().getResource("/javaseapp0812/res/data.json");//일반파일인 경우에는 패키지는 .대신 /로 한다.
		/* DTO를 생성 하기 이전 코드 
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
			*/
		
			Movie movie = movieList.get(index);//영화의 제목과 url을 얻는다.
			
			try {
				URL url = new URL(movie.getUrl());
				img =ImageIO.read(url);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
//	}
	public static void main(String[] args) {
		new Gallery();
	}
	
}
