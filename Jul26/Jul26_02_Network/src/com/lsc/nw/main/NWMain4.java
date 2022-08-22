package com.lsc.nw.main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NWMain4 {
    public static void main(String[] args) {
        String addr = "http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/json/RealtimeCityAir/1/25/";
        try{
            URL u = new URL(addr);
            HttpURLConnection huc = (HttpURLConnection) u.openConnection();
            InputStream is = huc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is,"utf-8");

            JSONParser jp = new JSONParser();
            JSONObject jo = (JSONObject) jp.parse(isr);
            JSONObject cssn = (JSONObject) jo.get("RealtimeCityAir");
            JSONArray r = (JSONArray) cssn.get("row");

            for(int i =0; i<r.size(); i++){
                JSONObject statation = (JSONObject) r.get(i);
                System.out.println(statation.get("MSRDT"));
                System.out.println(statation.get("MSRRGN_NM")+""+statation.get("MSRSTE_NM"));
                System.out.println("미세먼지 : "+statation.get("PM10"));
                System.out.println("초미세먼지 : "+statation.get("PM25"));
                System.out.println("오늘 미세먼지 : "+statation.get("IDEX_NM"));
                System.out.println("--------------------------------------------");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
