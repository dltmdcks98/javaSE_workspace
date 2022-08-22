package com.lsc.nw.main;

import com.lsc.nw.stringCleaner.StringCleaner;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

//DevNaver ID: FH2X7xmgHzfhxZOwmM4K
//DevNaver PW: Xl615uK2WK
// https://openapi.naver.com/v1/search/news.xml

public class NTMain2 {
    public static void main(String[] args) {
        String addr = "https://openapi.naver.com/v1/search/news.xml?sort=sim&display=10&query=";

        Scanner input = new Scanner(System.in);
        System.out.println("뭐 : ");
        String q = input.next();

        try{
            q = URLEncoder.encode(q,"UTF-8");
            URL u = new URL(addr+q);
            HttpURLConnection huc = (HttpURLConnection) u.openConnection();
            huc.addRequestProperty("X-Naver-Client-Id","FH2X7xmgHzfhxZOwmM4K");
            huc.addRequestProperty("X-Naver-Client-Secret","Xl615uK2WK");

            //xpp.setInput에 필요해서 설정함
            InputStream is = huc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is,"UTF-8");
            BufferedReader br = new BufferedReader(isr);

            XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = xppf.newPullParser();
            xpp.setInput(is,"UTF-8");
            int what = xpp.getEventType();
            String t= null;
            boolean data =false;//앞에 쓸데없는거 제거
            while(what!=XmlPullParser.END_DOCUMENT){
                if(what==XmlPullParser.START_TAG){
                    t= xpp.getName();
                    if(t.equals("item")){
                        data = true;
                    }
                } else if (what==XmlPullParser.TEXT) {
                    if(data){
                        if(t.equals("title")){
                            System.out.println(StringCleaner.clean(xpp.getText()));
                        } else if (t.equals("description")) {
                            System.out.println(StringCleaner.clean(xpp.getText())+"\r\n");
                        }
                    }


                } else if (what==XmlPullParser.END_TAG) {
                }
                xpp.next();
                what = xpp.getEventType();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
