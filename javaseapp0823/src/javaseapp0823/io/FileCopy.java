package javaseapp0823.io;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

public class FileCopy extends JFrame {
	JButton bt;
	JTextField t_ori,t_dest;
	JProgressBar bar;
	//FileInputStream fis;	//바이트 기반의 파일입력 스트림
	//FileOutputStream fos;	//바이트 기반의 파일출력 스트림
	FileReader fis;			//문자 기반, 이미지와 같은 것은 안됨
	FileWriter fos;			//문자 기반, 이미지와 같은 것은 안됨
	public FileCopy() {
		bt = new JButton("복사실행");
		t_ori = new JTextField(30);
		t_dest = new JTextField(30);
		bar = new JProgressBar();
		
		
		//스타일
		bar.setPreferredSize(new DimensionUIResource(380, 55));
		bar.setBackground(Color.CYAN);
		
		//조립
		setLayout(new FlowLayout());
		add(bt);
		add(t_ori);
		add(t_dest);
		add(bar);
		
		//윈도우 창 보이기
		setSize(400,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//이벤트 구현하기
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				copy();
			}
		});
	}
	
	public void copy() {
		
		try {
			String oriPath = t_ori.getText();
			String destPath = t_dest.getText();
			
			//fis = new FileInputStream(oriPath);	//파일을 대상으로 빨대를 꽂는다.
			fis= new FileReader(oriPath);
			
			//파일을 대상으로 한 출력스트림인 FileOutputStream은 생성시 빈(empty)파일을 생성해준다.	
			//fos = new FileOutputStream(destPath);
			fos = new FileWriter(destPath);
			
			//입력스트림으로부터 1byte 읽기
			int data = -1;
			
			while(true) {
				data = fis.read();
				if(data==-1)break;
				System.out.println((char)data);
				data++;
				fos.write(data);//파일출력스트림으로 ,1byte 쓰기, 한글과 같은 경우에도 깨지지 않는다 
			}
			JOptionPane.showMessageDialog(this, "복사완료");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new FileCopy();
	}
}
