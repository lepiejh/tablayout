package com.bigkoo.pickerview.utils;

public class StringUtils {

    public static String parseToData(String s){
        if (s.length() == 19){
            return s;
        }else {
            String[] a = s.split(" ");
            String a1 = a[0];
            String a2 = a[1];
            String[] b = a1.split("-");
            String b1 = b[0];
            String b2 = b[1];
            String b3 = b[2];
            String[] c = a2.split(":");
            String c1 = c[0];
            String c2 = c[1];
            String c3 = c[2];
            return intToString(b1)+"-"+intToString(b2)+"-"+intToString(b3)+" "+intToString(c1)+":"+intToString(c2)+":"+intToString(c3);
        }
    }

    public static String intToString(String s){
        int a = com.ved.framework.utils.StringUtils.parseInt(s);
        if (a < 10){
            return "0"+a;
        }else {
            return com.ved.framework.utils.StringUtils.parseStr(a);
        }
    }
}
