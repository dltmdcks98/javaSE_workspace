package com.lsc.nw.main;

import com.sun.org.apache.xerces.internal.xni.parser.XMLPullParserConfiguration;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import javax.imageio.stream.FileImageOutputStream;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class NTMain {
    public static void main(String[] args) {
        String addr = "http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/RealtimeCityAir/1/25/";
        try{
            URL u = new URL(addr);
            HttpURLConnection huc = (HttpURLConnection) u.openConnection();
            InputStream is = huc.getInputStream();
            XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = xppf.newPullParser();
            xpp.setInput(is,"UTF-8");

            //파일로 입력
            FileOutputStream fos = new FileOutputStream("D:\\LSC\\Java\\Java_Study_SL\\Jul26\\dust.csv",true);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);

            int what = xpp.getEventType();
            String temp=null;

            while(what!=XmlPullParser.END_DOCUMENT){
                if(what == XmlPullParser.START_TAG){
                    temp = xpp.getName();
                } else if (what == XmlPullParser.TEXT) {
                    if(temp.equals("MSRDT")){
                        String date = xpp.getText();

                        System.out.println(date.substring(0,4)+"년 "+date.substring(4,6)+"월 "+date.substring(6,8)+"일 "+date.substring(8,10)+"시 "+date.substring(10,12)+"분 ");
                        bw.write(date.substring(0,4)+"년 "+date.substring(4,6)+"월 "+date.substring(6,8)+"일 "+date.substring(8,10)+"시 "+date.substring(10,12)+"분 "+",");
                    }else if(temp.equals("MSRRGN_NM")){
                        System.out.print(xpp.getText()+",");
                        bw.write(xpp.getText());
                    } else if (temp.equals("MSRSTE_NM")) {
                        System.out.println(xpp.getText());
                        bw.write(xpp.getText()+",");
                    } else if (temp.equals("PM10")) {
                        System.out.println("미세먼지 농도 : "+xpp.getText()+" ㎍/㎥");
                        bw.write("미세먼지 농도 : "+xpp.getText()+" ㎍/㎥"+",");
                    } else if (temp.equals("PM25")) {
                        System.out.println("초미세먼지 농도 : "+xpp.getText()+" ㎍/㎥");
                        bw.write("초미세먼지 농도 : "+xpp.getText()+" ㎍/㎥"+",");
                    } else if (temp.equals("IDEX_NM")) {
                        System.out.println("오염 정도 : "+xpp.getText());
                        bw.write("오염 정도 : "+xpp.getText()+"\r\n");
                        System.out.println();
                    }
                } else if (what==XmlPullParser.END_TAG) {
                    temp="";

                }
                xpp.next();
                what = xpp.getEventType();
            }
            is.close();
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
