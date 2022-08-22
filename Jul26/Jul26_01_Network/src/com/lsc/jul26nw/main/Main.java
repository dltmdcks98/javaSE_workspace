package com.lsc.jul26nw.main;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


//
public class Main {
    public static void main(String[] args) {
        String addr = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4141062000";
        try{
            URL u= new URL(addr);
            HttpURLConnection huc = (HttpURLConnection) u.openConnection();

            InputStream is = huc.getInputStream();

            XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();

            //외부 라이브러리 사용
            XmlPullParser xpp = xppf.newPullParser();
            xpp.setInput(is,"utf-8");//XML은 대부분 UTF-8로 인코딩 되어있다.
            int what = xpp.getEventType(); //처음에 시작되는 값
            String t = null;
            while(what != XmlPullParser.END_DOCUMENT){//문서의 끝이 된다면
                if(what == XmlPullParser.START_TAG){
                   t = xpp.getName();
                }else if (what==XmlPullParser.TEXT) {
                    if(t.equals("hour")){
                        System.out.println(xpp.getText()+"시 까지");
                    }else if(t.equals("temp")){
                        System.out.printf("%sC",xpp.getText());
                    } else if (t.equals("wfKor")) {
                        System.out.println(xpp.getText());
                    }
                } else if (what == XmlPullParser.END_TAG) {
                    t="";//XML파일에 태그 끝에 엔터(\r\n)이 되어있어서 그걸 초기화 해줘야함 -> 안하면 text로 읽힘
                }

                xpp.next(); // 순서가 태그 시작 -> 데이터 -> 태그 끝 -> 다음 태그 시작 순으로 연속된다.
                what = xpp.getEventType();//
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}