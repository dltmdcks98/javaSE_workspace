package com.lsc.jul25.nw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class NwMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream is = null;
		String addr = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4141062000";
		try {
			URL u = new URL(addr);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();//단순히 연결만 
			
			is = huc.getInputStream();//java로 데이터 수신
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
		
		try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
