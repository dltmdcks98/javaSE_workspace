package com.lsc.nw.main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class NWMain5 {
    public static void main(String[] args) {
        System.out.println("검색할 지역 : ");
        Scanner input = new Scanner(System.in);
        String location = input.next();
        String addr = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr";
        InputStreamReader isr = null;
        try {
            URL u = new URL(addr);
            HttpURLConnection huc = (HttpURLConnection) u.openConnection();
            InputStream is = huc.getInputStream();
            isr = new InputStreamReader(is);
            JSONParser jp = new JSONParser();
            JSONObject jo = (JSONObject) jp.parse(isr);
            System.out.println("지역 : " + jo.get("name"));

            while (true) {
                JSONArray ja = (JSONArray) jo.get("weather");
                JSONObject weather = (JSONObject) ja.get(0);
                JSONObject temp = (JSONObject) jo.get("main");


                System.out.println(LocalDate.now());
                System.out.println(weather.get("description"));
                System.out.println("최대 기온 : " + temp.get("temp_max") + " C" + " 최저 기온 :" + temp.get("temp_min") + " C");

                Thread.sleep(5000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        try{
            isr.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
