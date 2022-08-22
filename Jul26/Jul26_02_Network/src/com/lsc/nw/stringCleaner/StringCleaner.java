package com.lsc.nw.stringCleaner;

public class StringCleaner {
    public static String clean(String s){
        s= s.replace("<b>","");
        s= s.replace("</b>","");
        s= s.replace("&quot;","");


        return s;
    }
}
