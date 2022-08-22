package com.lsc.nw.main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NWMain3 {
    public static void main(String[] args) {
        String addr = "http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/json/CardSubwayStatsNew/1/548/20151101";

        try {
            URL u = new URL(addr);
            HttpURLConnection huc = (HttpURLConnection) u.openConnection();
            InputStream is = huc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is,"utf-8");

            //JSON , JSONViewer로 하나하나 객체인지 배열인지 확인하면서 작성해야함
            JSONParser jp = new JSONParser();
//            JSONArray ja = jp.parse(isr);//JSON 시작이 []배열로 되어있을때
            JSONObject jo = (JSONObject) jp.parse(isr); // Json 시작이 {}이렇게 되어있을때
            JSONObject cssn = (JSONObject) jo.get("CardSubwayStatsNew");//객체 안에 있는 "변수"를 찾아라
            JSONArray r = (JSONArray) cssn.get("row");//CardSubwayStatsNew 안에 row 배열을 찾아라
            for(int i =0; i<r.size();i++){
                JSONObject station = (JSONObject) r.get(i);
                System.out.println(station.get("LINE_NUM"));
                System.out.println(station.get("SUB_STA_NM"));
                System.out.println(station.get("RIDE_PASGR_NUM"));
                System.out.println(station.get("ALIGHT_PASGR_NUM"));
                System.out.println("-----------------------------------");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
