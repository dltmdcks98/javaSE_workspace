package com.lsc.jul25.nw;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class NwMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String addr = "https://www.naver.com/";
		try {
			URL u = new URL(addr);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();//단순히 연결만 
			
			InputStream is = huc.getInputStream();//java로 데이터 수신
			InputStreamReader isr= new InputStreamReader(is,"utf-8"); //인코딩 방식이 다르면 여기서 맞춰줘야함 
			BufferedReader br = new BufferedReader(isr);
			
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();//네트워크 통신에서는 그렇게 중요하지 않음, 서버측에서 알아서 끊음 안하고 무한 반복하면 DDOS
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
